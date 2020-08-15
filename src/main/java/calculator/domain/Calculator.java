package calculator.domain;

public class Calculator {

    public int calculate(String input) {
        Numbers numbers = Numbers.of(input);

        return numbers.add();
    }

}
