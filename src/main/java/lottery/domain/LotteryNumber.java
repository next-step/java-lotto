package lottery.domain;

import java.util.Objects;

import static lottery.Constant.LOTTERY_MAX_NUMBER;
import static lottery.Constant.LOTTERY_MIN_NUMBER;

public class LotteryNumber {
    private final int number;

    public LotteryNumber(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다. 입력한 값:" + number);
        }
        this.number = number;
    }

    private static boolean isInRange(int number) {
        return number >= LOTTERY_MIN_NUMBER && number <= LOTTERY_MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
