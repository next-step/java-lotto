package lottery_auto.type;

public enum ProfitRateMessage {
    PROIFIT_LOSS("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    PROIFIT_BENEFIT("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)"),
    PROIFIT_BREAK_EVEN("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");

    private final String message;

    ProfitRateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
