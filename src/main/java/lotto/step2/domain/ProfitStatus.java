package lotto.step2.domain;

public enum ProfitStatus {
    SAME("본전"),
    LOSS("손해"),
    GAIN("이득");

    private final String description;

    ProfitStatus(String description) {
        this.description = description;
    }

    public static ProfitStatus from(double profitRate){
        if(profitRate < 1){
            return LOSS;
        }

        if(profitRate > 1){
            return GAIN;
        }
        return SAME;
    }

    public String getDescription() {
        return description;
    }
}
