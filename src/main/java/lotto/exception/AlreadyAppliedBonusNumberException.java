package lotto.exception;

public class AlreadyAppliedBonusNumberException extends RuntimeException {
    public AlreadyAppliedBonusNumberException() {
        super("보너스 번호가 이미 설정 되었으므로 변경이 불가합니다.");
    }
}
