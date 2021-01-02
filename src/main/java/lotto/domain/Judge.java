package lotto.domain;

public enum Judge {
    PROFIT("이익이"),
    LOSS("손해");

    private static final int PROFIT_STANDARD = 1;

    private final String judgeMessage;

    Judge(String judgeMessage) {
        this.judgeMessage = judgeMessage;
    }

    public String getJudgeMessage() {
        return judgeMessage;
    }

    public static Judge judge(double profitRate) {
        return profitRate >= PROFIT_STANDARD ? PROFIT : LOSS;
    }
}
