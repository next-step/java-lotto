package calculator;

import java.util.Arrays;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String strings = "2 + 3 * 4 / 2";
        StringCalculator stringCalculator = new StringCalculator(Arrays.asList(strings.split(" ")));
        System.out.println(stringCalculator.calculate().getNumber());
    }
}
