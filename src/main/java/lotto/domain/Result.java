package lotto.domain;

import lotto.generic.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result {
    private List<LottoStatus> lottoResults = new ArrayList<>();

    public void report(final LottoStatus lottoStatus) {
        lottoResults.add(lottoStatus);
    }

    public long findCount(final LottoStatus lottoStatus) {
        return lottoResults.stream()
                .filter(lottoResult -> Objects.equals(lottoResult, lottoStatus))
                .count();
    }

    public double calculateRatio() {
        return sumWinningAmount().toRatio(calculatePurchaseAmount());
    }

    private Money sumWinningAmount() {
        return Money.sum(lottoResults, LottoStatus::getWinningAmount);
    }

    private Money calculatePurchaseAmount() {
        return LottoGame.LOTTO_PRICE.times(lottoResults.size());
    }
}
