package StringCalculator.Calculator;

import java.util.function.BinaryOperator;

public class ComplexCalculator {
    public static float complexCalculate(final String input) {
        String[] inputSplit = input.split(" ");

        float result = Float.parseFloat(inputSplit[0]);

        if (inputSplit.length == 1) {
            return result;
        }

        for (int i=1; i < inputSplit.length; i+=2) {
            BinaryOperator<Float> function = CalculatorOperator.valueOfSign(inputSplit[i]).getFunction();
            result = function.apply(result, Float.parseFloat(inputSplit[i + 1]));
        }

        return result;
    }
}
