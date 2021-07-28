package lotto.exception;

public class IllegalBonusNumberException extends RuntimeException {
    public IllegalBonusNumberException(int number) {
        super("당첨번호에 포함된 번호를 선택할 수 없습니다. ===" + number);
    }
}
