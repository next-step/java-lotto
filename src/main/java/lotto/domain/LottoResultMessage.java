package lotto.domain;

import lotto.common.LottoConstants;

public enum LottoResultMessage {
    PROFIT("이득이"),
    PRINCIPAL("본전이"),
    LOSS("손해");

    private final String message;

    LottoResultMessage(String message) {
        this.message = message;
    }

    public static String message(float rateOfReturn){

        if (rateOfReturn > LottoConstants.PRINCIPAL_RATE) {
            return PROFIT.message;
        } else if (rateOfReturn == LottoConstants.PRINCIPAL_RATE) {
            return PRINCIPAL.message;
        }

        return LOSS.message;
    }
}
