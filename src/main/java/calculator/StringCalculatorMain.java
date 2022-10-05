package calculator;

import java.util.Arrays;

public class StringCalculatorMain {
    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();
        String strings = "3 + 5 - 3";

        Number result = stringCalculator.calculate(Arrays.asList(strings.split(" ")));
        System.out.println(result.getNumber());

    }
}
