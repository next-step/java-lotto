package step2.domain;

public class LottoGameResultDto {

    private final double earningRate;
    private final int firstPrizeCount;
    private final int secondPrizeCount;
    private final int thirdPrizeCount;
    private final int forthPrizeCount;
    private final int fifthPrizeCount;

    public LottoGameResultDto(double earningRate, int firstPrizeCount, int secondPrizeCount,
        int thirdPrizeCount, int forthPrizeCount, int fifthPrizeCount) {
        this.earningRate = earningRate;
        this.firstPrizeCount = firstPrizeCount;
        this.secondPrizeCount = secondPrizeCount;
        this.thirdPrizeCount = thirdPrizeCount;
        this.forthPrizeCount = forthPrizeCount;
        this.fifthPrizeCount = fifthPrizeCount;
    }

    public double getEarningRate() {
        return earningRate;
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

    public int getForthPrizeCount() {
        return forthPrizeCount;
    }

    public int getFifthPrizeCount() {
        return fifthPrizeCount;
    }

    @Override
    public String toString() {
        return "LottoGameResultDto{" +
            "earningRate=" + earningRate +
            ", firstPrizeCount=" + firstPrizeCount +
            ", secondPrizeCount=" + secondPrizeCount +
            ", thirdPrizeCount=" + thirdPrizeCount +
            ", forthPrizeCount=" + forthPrizeCount +
            ", fifthPrizeCount=" + fifthPrizeCount +
            '}';
    }
}
