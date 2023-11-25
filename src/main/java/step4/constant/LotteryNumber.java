package step4.constant;

import java.util.ArrayList;
import java.util.List;

import step4.util.LotteryUtil;

public class LotteryNumber {

    private static final List<LotteryNumber> ALL_NUMBERS;

    private final int value;

    static {
        ALL_NUMBERS = new ArrayList<>();
    }

    public LotteryNumber(int value) {
        LotteryUtil.validateNumber(value);
        this.value = value;
    }

    public static List<LotteryNumber> of(List<Integer> numbers) {
        for (int number : numbers) {
            ALL_NUMBERS.add(new LotteryNumber(number));
        }

        return ALL_NUMBERS;
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
}
