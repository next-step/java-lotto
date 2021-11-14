package calculation;

import java.util.Arrays;

public class Number {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "error : 음수는 사용할수 없습니다.";
    private static final String PLUS = "+";
    private int number;

    public Number(int[] numbers) {
        checkNegativeNumber(numbers);
        this.number = findTheFirstNumber(numbers);
    }

    private void checkNegativeNumber(int[] numbers) {
        long count = Arrays.stream(numbers)
                .filter(number -> number < 0)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int findTheFirstNumber(int[] numbers) {
        return numbers[0];
    }

    public int getNumber() {
        return number;
    }

    public void plus(int secondNumber){
        number = Calculation.calculate(PLUS, number, secondNumber);
    }
}
