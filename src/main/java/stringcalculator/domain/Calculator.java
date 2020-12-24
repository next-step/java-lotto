package stringcalculator.domain;

import stringcalculator.utils.Parser;

import java.util.List;

public class Calculator {
    private static final int LESS_THAN = 0;

    private final List<String> numbers;

    public Calculator(List<String> numbers) {
        this.numbers = numbers;
    }

    public int add() {
        int sum = 0;
        for (String number : numbers) {
            checkNumber(number);

            int numeric = Parser.parse(number);
            sum += numeric;
        }

        return sum;
    }

    private void checkNumber(String number) {
        if(Parser.parse(number) < LESS_THAN) {
            throw new RuntimeException("0 이하 숫자는 입력할 수 없습니다.");
        }
    }
}
