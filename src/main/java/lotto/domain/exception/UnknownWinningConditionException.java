package lotto.domain.exception;

public class UnknownWinningConditionException extends RuntimeException {

    public UnknownWinningConditionException() {
        super("해당 당첨 여부 조건은 없습니다.");
    }

}
