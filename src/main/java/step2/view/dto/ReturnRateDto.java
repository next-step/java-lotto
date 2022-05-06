package step2.view.dto;

import step2.domain.ReturnRate;

public class ReturnRateDto {

    private static final String PROFIT_MESSAGE = "이득입니다.";
    private static final String LOSS_MESSAGE = "손해입니다.";

    private final String roundReturnRate;
    private final String profitMessage;

    public ReturnRateDto(ReturnRate returnRate) {
        this.roundReturnRate = round(returnRate.getValue());
        this.profitMessage = initProfitMessage(returnRate);
    }

    private String round(double returnRate) {
        return String.format("%.2f", returnRate);
    }

    private String initProfitMessage(ReturnRate returnRate) {
        if (returnRate.isProfitable()) {
            return PROFIT_MESSAGE;
        }
        return LOSS_MESSAGE;
    }

    @Override
    public String toString() {
        return "총 수익률은 " + this.roundReturnRate + "입니다. => " + this.profitMessage;
    }
}
