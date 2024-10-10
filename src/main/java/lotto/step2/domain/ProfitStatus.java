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
        if(profitRate == 1){
            return SAME;
        }

        if(profitRate < 1){
            return LOSS;
        }

        if(profitRate > 1){
            return GAIN;
        }
        throw new IllegalArgumentException("수익률 상태를 확인할 수 없습니다");
    }

    public String getDescription() {
        return description;
    }
}
