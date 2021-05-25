package lotto.model;

public enum LottoResultMessage {
    PROFIT("이득이"),
    PRINCIPAL("본전이"),
    LOSS("손해");

    private static final int PRINCIPAL_RATE = 1;
    private final String message;

    LottoResultMessage(String message) {
        this.message = message;
    }

    public static String message(float rateOfReturn) {

        if (rateOfReturn > PRINCIPAL_RATE) {
            return PROFIT.message;
        }

        if (rateOfReturn == PRINCIPAL_RATE) {
            return PRINCIPAL.message;
        }

        return LOSS.message;
    }
}
