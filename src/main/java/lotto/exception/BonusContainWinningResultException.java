package lotto.exception;

public class BonusContainWinningResultException extends RuntimeException{
    private static final String MESSAGE = "보너스 번호는 당첨번호에 포함될 수 없습니다.";

    public BonusContainWinningResultException() {
        super(MESSAGE);
    }
}
