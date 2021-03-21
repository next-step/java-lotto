package lottery.domain;

import static lottery.domain.LotteryNumber.LOTTERY_NUMBER_MAX;
import static lottery.domain.LotteryNumber.LOTTERY_NUMBER_MIN;

public class InvalidBonusNumberException extends RuntimeException {

    private static final String MESSAGE =
        String.format(
            "보너스 번호는 %d ~ %d 사이의 번호여야 하며, 당첨 번화 중복되어서는 안됩니다.",
            LOTTERY_NUMBER_MIN,
            LOTTERY_NUMBER_MAX
        );

    public InvalidBonusNumberException() {
        super(MESSAGE);
    }
}
