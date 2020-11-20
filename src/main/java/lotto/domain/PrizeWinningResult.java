package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class PrizeWinningResult {

    private final int paidMoney;
    private List<Integer> prizeMoneys;
    private final int firstPrizeCount;
    private final int secondPrizeCount;
    private final int thirdPrizeCount;
    private final int fourthPrizeCount;

    public PrizeWinningResult(int paidMoney, List<Integer> prizeMoney, int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount, int fourthPrizeCount) {
        this.paidMoney = paidMoney;
        this.prizeMoneys = prizeMoney;
        this.firstPrizeCount = firstPrizeCount;
        this.secondPrizeCount = secondPrizeCount;
        this.thirdPrizeCount = thirdPrizeCount;
        this.fourthPrizeCount = fourthPrizeCount;
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getFirstPrizeMoney() {
        return prizeMoneys.get(0);
    }

    public int getSecondPrizeMoney() {
        return prizeMoneys.get(1);
    }

    public int getThirdPrizeMoney() {
        return prizeMoneys.get(2);
    }

    public int getFourthPrizeMoney() {
        return prizeMoneys.get(3);
    }

    public double getRateOfReturn() {
        int total = ((this.firstPrizeCount * this.prizeMoneys.get(0))
                + (this.secondPrizeCount * this.prizeMoneys.get(1))
                + (this.thirdPrizeCount * this.prizeMoneys.get(2))
                + (this.fourthPrizeCount * this.prizeMoneys.get(3)));

        if (total == 0) return 0;
        return (double) total / this.paidMoney;
    }

    public static PrizeWinningResult.Builder builder() {
        return new PrizeWinningResult.Builder();
    }

    static class Builder {

        private List<Integer> prizeMoneys;
        private List<Lotto> firstPrize;
        private List<Lotto> secondPrize;
        private List<Lotto> thirdPrize;
        private List<Lotto> fourthPrize;
        private int paidMoney;

        public Builder prizeMoneys(int firstPrizeMoney, int secondPrizeMoney, int thirdPrizeMoney, int fourPrizeMoney) {
            prizeMoneys = Arrays.asList(firstPrizeMoney, secondPrizeMoney, thirdPrizeMoney, fourPrizeMoney);
            return this;
        }

        public Builder firstPrize(List<Lotto> lottos) {
            this.firstPrize = lottos;
            return this;
        }

        public Builder secondPrize(List<Lotto> lottos) {
            this.secondPrize = lottos;
            return this;
        }

        public Builder thirdPrize(List<Lotto> lottos) {
            this.thirdPrize = lottos;
            return this;
        }

        public Builder fourthPrize(List<Lotto> lottos) {
            this.fourthPrize = lottos;
            return this;
        }

        public PrizeWinningResult build() {
            return new PrizeWinningResult(paidMoney, prizeMoneys, firstPrize.size(), secondPrize.size(), thirdPrize.size(), fourthPrize.size());
        }

        public Builder paidMoney(int paidMoney) {
            if( paidMoney <= 0 ) throw new PrizeWinningResultBulderException("로또 구입가격은 0 보다 커야 합니다.");
            this.paidMoney = paidMoney;
            return this;
        }

    }
}


