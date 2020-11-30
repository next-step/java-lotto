package lotto.domain;

public enum EarnRate {
    PROFIT("기준이 1이기 때문에 결과적으로 이득이라는 의미임"),
    EQUAL("기준이 1이기 때문에 이득도 손해도 없음"),
    LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임");

    private final String explanation;

    EarnRate(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public static String getExplanationMessage(double earn) {
        if (earn < 1) {
            return LOSS.getExplanation();
        } else if (earn == 1) {
            return EQUAL.getExplanation();
        }
        return PROFIT.getExplanation();
    }
}
