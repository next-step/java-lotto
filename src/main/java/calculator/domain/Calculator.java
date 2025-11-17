package calculator.domain;

public class Calculator {

    public static int plus(TargetNumber targetNumber) {
        return targetNumber.plus();
    }

    public static int minus(TargetNumber targetNumber) {
        return targetNumber.minus();
    }

    public static int multiplication(TargetNumber targetNumber) {
        return targetNumber.multiplication();
    }

    public static int division(TargetNumber targetNumber) {
        return targetNumber.division();
    }
}
