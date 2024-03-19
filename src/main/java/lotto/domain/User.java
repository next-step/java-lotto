package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private int purchasePrice;
    private List<Lotto> lottos = new ArrayList<>();
    private final LottoSeller lottoSeller;

    public User(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public void purchaseLottos(int purchasePrice) {
        lottos = lottoSeller.sellLottos(purchasePrice);

        this.purchasePrice = purchasePrice;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public UserLottoResult getUserLottoResult(Lotto winningLotto) {
        BigDecimal totalIncome = new BigDecimal(0);
        UserLottoResult userLottoResult = new UserLottoResult();

        List<LottoResult> lottoResults = lottos.stream().map(lotto -> lotto.isWinningLotto(winningLotto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        for (LottoResult lottoResult : lottoResults) {
            userLottoResult.addCount(lottoResult);
            totalIncome = totalIncome.add(new BigDecimal(lottoResult.getWinningPrice()));
        }

        double rateOfReturn = totalIncome.divide(new BigDecimal(purchasePrice), 2, RoundingMode.HALF_UP).doubleValue();
        userLottoResult.setRateOfReturn(rateOfReturn);

        return userLottoResult;
    }

}
