package step2.view.dto;

public class ReturnRateDto {

    private static final String PROFIT_MESSAGE = "이득입니다.";
    private static final String LOSS_MESSAGE = "손해입니다.";

    private final String roundReturnRate;
    private final String profitMessage;

    public ReturnRateDto(double returnRate) {
        this.roundReturnRate = roundToString(returnRate);
        this.profitMessage = initProfitMessage(returnRate);
    }

    private String roundToString(double returnRate) {
        return String.format("%.2f", returnRate);
    }

    private String initProfitMessage(double returnRate) {
        if (1 < returnRate) {
            return PROFIT_MESSAGE;
        }
        return LOSS_MESSAGE;
    }

    @Override
    public String toString() {
        return "총 수익률은 " + this.roundReturnRate + "입니다. => " + this.profitMessage;
    }
}
