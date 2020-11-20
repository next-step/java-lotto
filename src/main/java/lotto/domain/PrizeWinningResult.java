package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeWinningResult {

    private final int paidMoney;
    private Map<LottoRanking, Integer> rankedLottoCounts;

    public PrizeWinningResult(int paidMoney, List<RankedLotto> rankedLottos) {
        this.paidMoney = paidMoney;
        this.rankedLottoCounts = rankedLottos.stream()
                .collect(Collectors.toMap(
                        it -> it.getRanking(),
                        it -> 1,
                        (current, plus) -> current + plus));
    }

    public int getRankedLottoCount(LottoRanking ranking){
        return rankedLottoCounts.getOrDefault(ranking, 0);
    }

    public double getRateOfReturn() {
        long total = ((getRankedLottoCount(LottoRanking.FIRST) * LottoRanking.FIRST.getWinningMoney())
                + (getRankedLottoCount(LottoRanking.SECOND) * LottoRanking.SECOND.getWinningMoney())
                + (getRankedLottoCount(LottoRanking.THIRD) * LottoRanking.THIRD.getWinningMoney())
                + (getRankedLottoCount(LottoRanking.FOURTH) * LottoRanking.FOURTH.getWinningMoney())
                + (getRankedLottoCount(LottoRanking.FIFTH) * LottoRanking.FIFTH.getWinningMoney()));

        if (total == 0) return 0;
        return (double) total / this.paidMoney;
    }

    public static PrizeWinningResult.Builder builder() {
        return new PrizeWinningResult.Builder();
    }

    static class Builder {

        private int paidMoney;
        private List<RankedLotto> rankedLottos;

        public PrizeWinningResult build() {
            return new PrizeWinningResult(paidMoney, rankedLottos);
        }

        public Builder paidMoney(int paidMoney) {
            this.paidMoney = paidMoney;
            return this;
        }

        public Builder rankedLottos(List<RankedLotto> rankedLottos) {
            this.rankedLottos = rankedLottos;
            return this;
        }
    }
}


