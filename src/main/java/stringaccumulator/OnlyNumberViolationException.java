package stringaccumulator;

public class OnlyNumberViolationException extends IllegalArgumentException {
    OnlyNumberViolationException() {
        super(Constant.ONLY_NUMBER);
    }
}
