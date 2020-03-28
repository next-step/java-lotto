package lotto.view;

public class StatisticDataDto {
    private int matchCount3 = 0;
    private int matchCount4 = 0;
    private int matchCount5 = 0;
    private int matchCount6 = 0;
    private double earningRate = 0;

    public int getMatchCount3() {
        return matchCount3;
    }

    public int getMatchCount4() {
        return matchCount4;
    }

    public int getMatchCount5() {
        return matchCount5;
    }

    public int getMatchCount6() {
        return matchCount6;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void setMatchCount3(int matchCount3) {
        this.matchCount3 = matchCount3;
    }

    public void setMatchCount4(int matchCount4) {
        this.matchCount4 = matchCount4;
    }

    public void setMatchCount5(int matchCount5) {
        this.matchCount5 = matchCount5;
    }

    public void setMatchCount6(int matchCount6) {
        this.matchCount6 = matchCount6;
    }

    public void setEarningRate(double earningRate) {
        this.earningRate = earningRate;
    }
}
