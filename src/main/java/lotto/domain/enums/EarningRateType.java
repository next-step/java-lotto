package lotto.domain.enums;

public enum EarningRateType {
    GAIN("이득"), LOSS("손해"), BREAK_EVEN("본전");

    private String description;

    EarningRateType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
