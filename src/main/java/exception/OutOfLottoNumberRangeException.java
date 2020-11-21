package exception;

public class OutOfLottoNumberRangeException extends IllegalArgumentException{
    final static String MESSAGE = "로또의 번호는 1 이상 45 이하여야 합니다.";
    public OutOfLottoNumberRangeException() {
        super(MESSAGE);
    }
}
