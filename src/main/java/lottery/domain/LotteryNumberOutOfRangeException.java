package lottery.domain;

public class LotteryNumberOutOfRangeException extends RuntimeException {

    private static final String MESSAGE =
            String.format(
                    "로또 번호는 %d ~ %d 사이의 번호여야 합니다.",
                    LotteryNumber.LOTTERY_NUMBER_MIN, LotteryNumber.LOTTERY_NUMBER_MAX);

    public LotteryNumberOutOfRangeException() {
        super(MESSAGE);
    }

}
