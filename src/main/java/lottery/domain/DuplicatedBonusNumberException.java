package lottery.domain;

public class DuplicatedBonusNumberException extends RuntimeException {

    private static final String MESSAGE = "보너스 번호는 당첨 번호와 겹치지 않는 번호여야 합니다.";

    public DuplicatedBonusNumberException() {
        super(MESSAGE);
    }

}
