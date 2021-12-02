package calculator;

public class Calculator {

    public static Number calculate(String input) {
        Numbers numbers = new Numbers(input);
        numbers.sum();

        return numbers.result();
    }
}
