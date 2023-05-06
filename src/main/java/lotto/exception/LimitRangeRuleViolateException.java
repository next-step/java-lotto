package lotto.exception;

public class LimitRangeRuleViolateException extends IllegalArgumentException {
    public LimitRangeRuleViolateException() {
        super("LimitRange 가 잘못 입력되었습니다");
    }
}
