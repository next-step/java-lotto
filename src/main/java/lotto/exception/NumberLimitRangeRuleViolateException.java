package lotto.exception;

public class NumberLimitRangeRuleViolateException extends IllegalArgumentException {
    public NumberLimitRangeRuleViolateException() {
        super("LimitRange 가 잘못 입력되었습니다");
    }
}
