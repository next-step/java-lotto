package calculation;

import java.util.Arrays;

public class Number {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "error : 음수는 사용할수 없습니다.";
    private final int number;

    public Number(int[] numbers) {
        checkNegativeNumber(numbers);
        this.number = findTheValidValue(numbers);
    }

    private void checkNegativeNumber(int[] numbers) {
        long count = Arrays.stream(numbers)
                .filter(number -> number < 0)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private int findTheValidValue(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        return calculate(numbers);
    }

    private int calculate(int[] numbers) {
        int loopNumber = numbers.length - 1;
        int result = numbers[0];
        for (int i = 0; i < loopNumber; i++) {
            result = Calculation.calculate("+", result, numbers[i + 1]);
        }

        return result;
    }

    public int getNumber() {
        return number;
    }
}
