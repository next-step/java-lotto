package lotto.dto;

import java.util.Objects;

public class Summary {
    private long firstCount;
    private long secondCount;
    private long thirdCount;
    private long fourthCount;
    float profitRate;

    public Summary() {
    }

    public Summary(long firstCount, long secondCount, long thirdCount, long fourthCount, float profitRate) {
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.thirdCount = thirdCount;
        this.fourthCount = fourthCount;
        this.profitRate = profitRate;
    }

    public long firstCount() {
        return firstCount;
    }

    public void setFirstCount(long firstCount) {
        this.firstCount = firstCount;
    }

    public long secondCount() {
        return secondCount;
    }

    public void setSecondCount(long secondCount) {
        this.secondCount = secondCount;
    }

    public long thirdCount() {
        return thirdCount;
    }

    public void setThirdCount(long thirdCount) {
        this.thirdCount = thirdCount;
    }

    public long fourthCount() {
        return fourthCount;
    }

    public void setFourthCount(long fourthCount) {
        this.fourthCount = fourthCount;
    }

    public float profitRate() {
        return profitRate;
    }

    public void setProfitRate(float profitRate) {
        this.profitRate = profitRate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return firstCount == summary.firstCount && secondCount == summary.secondCount && thirdCount == summary.thirdCount && fourthCount == summary.fourthCount && Float.compare(profitRate, summary.profitRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCount, secondCount, thirdCount, fourthCount, profitRate);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "firstCount=" + firstCount +
                ", secondCount=" + secondCount +
                ", thirdCount=" + thirdCount +
                ", fourthCount=" + fourthCount +
                ", profitRate=" + profitRate +
                '}';
    }
}
