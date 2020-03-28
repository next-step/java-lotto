package stringaccumulator;

public class OnlyPositiveViolationException extends IllegalArgumentException {
    public OnlyPositiveViolationException() {
        super(Constant.ONLY_POSITIVE);
    }
}
