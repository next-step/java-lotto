package calculator.domain;

public interface OperatorFunction {
    long execute(long number1, long number2);

    static long add(long number1, long number2) {
        return number1 + number2;
    }

    static long subtract(long number1, long number2) {
        return number1 - number2;
    }

    static long multiple(long number1, long number2) {
        return number1 * number2;
    }

    static long divide(long number1, long number2) {
        long result = number1 / number2;
        if (result * number2 != number1)
            throw new IllegalArgumentException("result of division should be integer");
        return result;
    }

}
