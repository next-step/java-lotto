package lottery.domain;

public class InvalidLotteryException extends RuntimeException {

    private static final String MESSAGE =
        String.format(
            "로또 번호는 %d ~ %d 사이의 중복없는 번호 6개와 보너스 번호 1개로 구성되어야 합니다.",
            Lottery.LOTTERY_NUMBER_MIN,
            Lottery.LOTTERY_NUMBER_MAX
        );

    public InvalidLotteryException() {
        super(MESSAGE);
    }

}
