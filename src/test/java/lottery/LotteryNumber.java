package lottery;

public class LotteryNumber {

    private static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final int MINIMUM_LOTTERY_NUMBER = 1;

    LotteryNumber(Integer number) {
        if (number > MAXIMUM_LOTTERY_NUMBER || number < MINIMUM_LOTTERY_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}
