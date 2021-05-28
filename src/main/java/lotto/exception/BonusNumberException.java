package lotto.exception;

public class BonusNumberException extends RuntimeException {
    private static final String BONUS_NUMBER_EXCEPTION_MSG = "당첨 로또 번호에 포함된 번호 입니다.";

    public BonusNumberException() {
        System.out.println(BONUS_NUMBER_EXCEPTION_MSG);
    }
}
