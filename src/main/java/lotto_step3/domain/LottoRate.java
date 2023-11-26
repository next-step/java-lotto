package lotto_step3.domain;

public enum LottoRate {
    BENEFIT("이득이"),
    PRINCIPAL("본전이"),
    LOSS("손해");

    private String rateInfo;

    private static double BASE_RATE = 1.0;

    LottoRate(String rateInfo) {
        this.rateInfo = rateInfo;
    }

    public static String getInfo(double rate) {
        if (rate > BASE_RATE) {
            return BENEFIT.rateInfo;
        }
        if (rate == BASE_RATE) {
            return PRINCIPAL.rateInfo;
        }
        return LOSS.rateInfo;
    }
}
