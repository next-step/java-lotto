package lotto.domain.exception;

public class NullMarkingPaperException extends RuntimeException {

    public NullMarkingPaperException() {
        super("마킹지는 null 이어선 안됩니다.");
    }

}
