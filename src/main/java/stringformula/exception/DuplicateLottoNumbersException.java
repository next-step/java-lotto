package stringformula.exception;

public class DuplicateLottoNumbersException extends RuntimeException {
    public DuplicateLottoNumbersException() {
        super("로또 번호는 중복될 수 없습니다.");
    }
}
