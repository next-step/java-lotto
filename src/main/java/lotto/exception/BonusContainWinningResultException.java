package lotto.exception;

public class BonusContainWinningResultException extends RuntimeException {
    private static final String MESSAGE = "보너스 번호는 당첨번호에 포함될 수 없습니다. (중복된 번호: %d)";

    public BonusContainWinningResultException(int duplicate) {
        super(String.format(MESSAGE,duplicate));
    }
}
