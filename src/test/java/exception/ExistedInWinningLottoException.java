package exception;

public class ExistedInWinningLottoException extends IllegalArgumentException {
    private static final String MESSAGE = "이미 당첨 번호에 존재하는 숫자 입니다.";
    public ExistedInWinningLottoException() {
        super(MESSAGE);
    }
}
