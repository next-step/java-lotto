package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private PurchasePrice purchasePrice;
    private List<Lotto> lottos = new ArrayList<>();
    private final LottoSeller lottoSeller;

    public User(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public void purchaseLottos(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);

        lottos = lottoSeller.sellLottos(this.purchasePrice.countPurchasableLotto());
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public UserLottoResult getUserLottoResult(WinningLotto winningLotto) {
        BigDecimal totalIncome = new BigDecimal(0);
        UserLottoResult userLottoResult = new UserLottoResult();
        
        List<LottoWinningRank> lottoWinningRanks = lottos.stream().map(lotto -> lotto.isWinningLotto(winningLotto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        for (LottoWinningRank lottoWinningRank : lottoWinningRanks) {
            userLottoResult.addCount(lottoWinningRank);
            totalIncome = totalIncome.add(new BigDecimal(lottoWinningRank.getWinningPrice()));
        }

        double rateOfReturn = totalIncome.divide(new BigDecimal(purchasePrice.getPurchasePrice()), 2, RoundingMode.HALF_UP).doubleValue();
        userLottoResult.setRateOfReturn(rateOfReturn);

        return userLottoResult;
    }

}
