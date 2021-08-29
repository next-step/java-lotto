package lotto.gameresult;

public enum Gain {
    LOSS("손해"),
    BREAK_EVEN_POINT("본전"),
    GAIN("이익");

    public static final double BREAK_EVEN_POINT_PROFIT_RATE = 1.0;
    private final String status;

    Gain(String status) {
        this.status = status;
    }

    public static Gain decideStatusByProfitRate(double profitRate) {
        if (profitRate < BREAK_EVEN_POINT_PROFIT_RATE) {
            return LOSS;
        }

        if (profitRate > BREAK_EVEN_POINT_PROFIT_RATE) {
            return GAIN;
        }

        return BREAK_EVEN_POINT;
    }


    public String value() {
        return status;
    }
}
