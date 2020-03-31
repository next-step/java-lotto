package study.lotto.domain.exception;

public class NoDuplicatedNumberAllowedException extends IllegalArgumentException {
    public NoDuplicatedNumberAllowedException(String s) {
        super(s);
    }
}
