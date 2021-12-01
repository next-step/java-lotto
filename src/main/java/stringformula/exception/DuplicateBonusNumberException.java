package stringformula.exception;

public class DuplicateBonusNumberException extends RuntimeException {
    public DuplicateBonusNumberException() {
        super("보너스 번호가 중복될 수 없습니다.");
    }
}
