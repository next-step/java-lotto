package step4.constant;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumber {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private static final List<LotteryNumber> LOTTERY_NUMBERS = new ArrayList<>();

    private final int value;

    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            LOTTERY_NUMBERS.add(new LotteryNumber(i));
        }
    }

    public LotteryNumber(int value) {
        validateNumber(value);

        this.value = value;
    }

    public static List<LotteryNumber> of(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int number : numbers) {
            lotteryNumbers.add(getLotteryNumber(number));
        }

        return lotteryNumbers;
    }

    public static List<Integer> getNumbers(List<LotteryNumber> numbers) {
        List<Integer> allNumbers = new ArrayList<>();
        for (LotteryNumber number : numbers) {
            allNumbers.add(number.getValue());
        }

        return allNumbers;
    }

    private static LotteryNumber getLotteryNumber(int number) {
        return LOTTERY_NUMBERS.get(number - 1);
    }

    public int getValue() {
        return value;
    }

    private static void validateNumber(int number) {
        if (46 < number) {
            throw new IllegalArgumentException("잘 못 생성된 로또 번호 - " + number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LotteryNumber)) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) o;

        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return getValue();
    }
}
