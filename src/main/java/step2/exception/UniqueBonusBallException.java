package step2.exception;

public class UniqueBonusBallException extends IllegalArgumentException {
    private static final String UNIQUE_BONUS_BALL = "보너스볼은 지난당첨번호와 중복이 아니어야 합니다.";

    public UniqueBonusBallException() {
        super(UNIQUE_BONUS_BALL);
    }
}
