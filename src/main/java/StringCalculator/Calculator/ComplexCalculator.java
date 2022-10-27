package StringCalculator.Calculator;

import java.util.function.BiFunction;

public class ComplexCalculator {
    public static float complexCalculate(final String input) {
        String[] inputSplit = input.split(" ");

        float result = Float.parseFloat(inputSplit[0]);

        if (inputSplit.length == 1) {
            return result;
        }

        BiFunction <Float, Float, Float> function = convertOperator(inputSplit[1]);

        for (int i=2; i < inputSplit.length; i++) {
            if (i % 2 == 0) {
                result = function.apply(result, Float.parseFloat(inputSplit[i]));
            } else {
                function = convertOperator(inputSplit[i]);
            }
        }

        return result;
    }

    private static BiFunction <Float, Float, Float> convertOperator(String sign) {
        if (sign.equals(Calculator.Operator.ADD.getSign())) {
            return Calculator.Operator.ADD.getFunction();
        }
        if (sign.equals(Calculator.Operator.SUBTRACT.getSign())) {
            return Calculator.Operator.SUBTRACT.getFunction();
        }
        if (sign.equals(Calculator.Operator.MULTIPLY.getSign())) {
            return Calculator.Operator.MULTIPLY.getFunction();
        }
        if (sign.equals(Calculator.Operator.DIVIDE.getSign())) {
            return Calculator.Operator.DIVIDE.getFunction();
        }
        return null;
    }
}
