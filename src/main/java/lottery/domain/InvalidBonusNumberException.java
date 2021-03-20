package lottery.domain;

public class InvalidBonusNumberException extends RuntimeException {

    private static final String MESSAGE =
        String.format(
            "보너스 번호는 %d ~ %d 사이의 번호여야 하며, 당첨 번화 중복되어서는 안됩니다.",
            Lottery.LOTTERY_NUMBER_MIN,
            Lottery.LOTTERY_NUMBER_MAX
        );

    public InvalidBonusNumberException() {
        super(MESSAGE);
    }
}
