package StringCalculator.Calculator;

import java.util.function.BinaryOperator;

public class Calculator {
    public static BinaryOperator<Float> add =
            (number1, number2) -> number1 + number2;

    public static BinaryOperator<Float> subtract =
            (number1, number2) -> number1 - number2;

    public static BinaryOperator<Float> multiply =
            (number1, number2) -> number1 * number2;

    public static BinaryOperator<Float> divide =
            (number1, number2) -> number1 / number2;
}
