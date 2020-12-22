package lotto.domain;

public enum Judge {

    PROFIT("이익"),
    LOSS("손해");

    private final String judgeMessage;

    Judge(String judgeMessage) {
        this.judgeMessage = judgeMessage;
    }

    public String getJudgeMessage() {
        return judgeMessage;
    }

    public static Judge judge(double profitRate) {
        return profitRate > 1 ? PROFIT : LOSS;
    }
}
