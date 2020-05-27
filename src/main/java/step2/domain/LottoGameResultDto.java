package step2.domain;

public class LottoGameResultDto {

    private double earningRate;
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int forthPrizeCount;

    public LottoGameResultDto(double earningRate, int firstPrizeCount, int secondPrizeCount,
        int thirdPrizeCount, int forthPrizeCount) {
        this.earningRate = earningRate;
        this.firstPrizeCount = firstPrizeCount;
        this.secondPrizeCount = secondPrizeCount;
        this.thirdPrizeCount = thirdPrizeCount;
        this.forthPrizeCount = forthPrizeCount;
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
}
