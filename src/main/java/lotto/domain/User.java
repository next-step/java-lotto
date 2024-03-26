package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private PurchasePrice purchasePrice = new PurchasePrice(0);
    private List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(LottoSeller lottoSeller, int purchasePrice) {
        PurchasePrice currentPurchasePrice = new PurchasePrice(purchasePrice);
        this.purchasePrice = new PurchasePrice(currentPurchasePrice.getPurchasePrice() + this.purchasePrice.getPurchasePrice());

        lottos.addAll(lottoSeller.sellLottos(currentPurchasePrice.countPurchasableLotto()));
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

    public int getPurchasePrice() {
        return purchasePrice.getPurchasePrice();
    }

}
