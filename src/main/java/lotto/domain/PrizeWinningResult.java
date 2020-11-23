package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PrizeWinningResult {

    private final int paidMoney;
    private Map<LottoRanking, Integer> rankedLottoCounts;

    private PrizeWinningResult(int paidMoney, List<RankedLotto> rankedLottos) {
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

        long total = Arrays.stream(LottoRanking.values())
                .map(it -> getRankedLottoCount(it) * it.getWinningMoney())
                .reduce(Integer::sum).get();

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
            if( paidMoney <= 0 ) throw new PrizeWinningResultBulderException("로또 구입가격은 0 보다 커야 합니다.");
            this.paidMoney = paidMoney;
            return this;
        }

        public Builder rankedLottos(List<RankedLotto> rankedLottos) {
            this.rankedLottos = rankedLottos;
            return this;
        }
    }
}


