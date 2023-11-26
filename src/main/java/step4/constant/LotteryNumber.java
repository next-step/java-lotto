package step4.constant;

import java.util.ArrayList;
import java.util.List;

public class LotteryNumber {

    private static final List<LotteryNumber> ALL_NUMBERS;

    private final int value;

    static {
        ALL_NUMBERS = new ArrayList<>();
    }

    public LotteryNumber(int value) {
        validateNumber(value);

        this.value = value;
    }

    public static List<LotteryNumber> of(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int number : numbers) {
            lotteryNumbers.add(new LotteryNumber(number));
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
