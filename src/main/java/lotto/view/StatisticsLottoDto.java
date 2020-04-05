package lotto.view;

public class StatisticsLottoDto {

    private long firstGameCount = 0;
    private long secondGameCount = 0;
    private long thirdGameCount = 0;
    private long fourthGameCount = 0;
    private long fifthGameCount = 0;
    private double earningRate = 0;

    public long getFirstGameCount() {
        return firstGameCount;
    }

    public long getSecondGameCount() {
        return secondGameCount;
    }

    public long getThirdGameCount() {
        return thirdGameCount;
    }

    public long getFourthGameCount() {
        return fourthGameCount;
    }

    public long getFifthGameCount() {
        return fifthGameCount;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void setFirstGameCount(long firstGameCount) {
        this.firstGameCount = firstGameCount;
    }

    public void setSecondGameCount(long secondGameCount) {
        this.secondGameCount = secondGameCount;
    }

    public void setThirdGameCount(long thirdGameCount) {
        this.thirdGameCount = thirdGameCount;
    }

    public void setFourthGameCount(long fourthGameCount) {
        this.fourthGameCount = fourthGameCount;
    }

    public void setFifthGameCount(long fifthGameCount) {
        this.fifthGameCount = fifthGameCount;
    }

    public void setEarningRate(double earningRate) {
        this.earningRate = earningRate;
    }
}
