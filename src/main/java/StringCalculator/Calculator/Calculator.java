package StringCalculator.Calculator;

import java.util.function.BiFunction;

public class Calculator {
    enum Operator {
        ADD("+", Calculator.add),
        SUBTRACT("-", Calculator.subtract),
        MULTIPLY("*", Calculator.multiply),
        DIVIDE("/", Calculator.divide)
        ;
        private final String sign;
        private final BiFunction<Float, Float, Float> function;

        Operator(String sign, BiFunction<Float, Float, Float> function) {
            this.sign = sign;
            this.function = function;
        }

        public String getSign() {
            return sign;
        }

        public BiFunction<Float, Float, Float> getFunction() {
            return function;
        }
    }

    public static BiFunction<Float, Float, Float> add =
            (number1, number2) -> number1 + number2;

    public static BiFunction<Float, Float, Float> subtract =
            (number1, number2) -> number1 - number2;

    public static BiFunction<Float, Float, Float> multiply =
            (number1, number2) -> number1 * number2;

    public static BiFunction<Float, Float, Float> divide =
            (number1, number2) -> number1 / number2;
}
