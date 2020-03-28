package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private static final int ZERO = 0;

    private final List<String> numbers;

    public Numbers(String[] numbers) {
        for (String number : numbers) {
            isNumber(number);
            checkNegativeNum(number);
        }
        this.numbers = Arrays.asList(numbers);
    }

    public int sum() {
        int sum = ZERO;
        for (String number : this.numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (RuntimeException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
        }
    }

    private void checkNegativeNum(String number) {
        if (Integer.parseInt(number) < ZERO) {
            System.out.println("음수는 입력할 수 없습니다.");
            throw new RuntimeException();
        }
    }

}
