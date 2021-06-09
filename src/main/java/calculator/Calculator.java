package calculator;

import java.util.List;

public class Calculator {
    public int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
