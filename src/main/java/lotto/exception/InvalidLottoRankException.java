package lotto.exception;

public class InvalidLottoRankException extends IllegalArgumentException{
    private static final String MESSAGE = "올바르지 않은 RANK 입니다.";

    public InvalidLottoRankException() {
        super(MESSAGE);
    }
}
