package calculator;

import java.util.List;

public class Calculator {
    public int sumExpression(String expression) {
        Word word = new Word();
        return sumNumbers(word.makeNumbers(expression));
    }

    public int sumNumbers(List<Integer> numbers) {
        Word word = new Word();
        word.notNegativeValidation(numbers);
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
