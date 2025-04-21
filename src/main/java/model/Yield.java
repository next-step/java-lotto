package model;

public class Yield {
    private final double value;

    private Yield(int income, int investment) {
        this.value = (double) income / investment;
    }

    public static Yield of(int income, int investment) {
        return new Yield(income, investment);
    }

    public double valueOf() {
        return value;
    }

    public String verdictInKorean() {
        String verdict = "본전";

        if (value > 1) {
            verdict = "이득";
        }
        if (value < 1) {
            verdict = "손해";
        }

        return verdict;
    }
}
