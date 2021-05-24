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

    public int sumExpression(String expression) {
        Word word = new Word();
        if (word.isCustomInput(expression)) {
            return sumNumbers(word.makeNumbersInCustomExpression(expression));
        }

        return sumNumbers(word.makeNumbersInGeneralExpression(expression));
    }
}
