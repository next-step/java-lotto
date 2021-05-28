package lotto.exception;

public class DuplicatedBonusNumberException extends RuntimeException {
    public DuplicatedBonusNumberException() {
        super("보너스 번호는 당첨 번호와 중복 되지 않아야 합니다.");
    }
}
