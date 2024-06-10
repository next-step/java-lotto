package lotto;

public class LottoGameResult {
    private final long first;
    private final long second;
    private final long third;
    private final long fourth;
    private final long fifth;
    private final double profitRatio;

    public LottoGameResult(long first, long second, long third, long fourth, long fifth, double profitRatio) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.profitRatio = profitRatio;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    public long getThird() {
        return third;
    }

    public long getFourth() {
        return fourth;
    }

    public long getFifth() {
        return fifth;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
