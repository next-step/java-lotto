package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

import java.util.List;

public class LottoWinningResult {
    private List<LottoAward> awardResult;

    public LottoWinningResult(List<LottoAward> awardResult) {
        this.awardResult = awardResult;
    }

    public int getAwardCount(LottoAward award) {
        return (int) awardResult
                .stream()
                .filter(r -> r == award)
                .count();
    }

    public long getTotalPrize() {
        return awardResult
                .stream()
                .mapToLong(a -> a.getPrize())
                .sum();
    }

    public double getReturnOfInvestment() {
        return getTotalPrize() / getPurchaseAmount();
    }

    private double getPurchaseAmount() {
        return (double) awardResult.size() * LottoGameRule.getLottoPrice();
    }
}
