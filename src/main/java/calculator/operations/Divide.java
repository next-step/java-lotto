package calculator.operations;

public class Divide implements Operator{
    public static final String symbol = "/";

    @Override
    public int apply(int a, int b) {
        validate(b);
        validate(a, b);
        return a / b;
    }

    private void validate(int a, int b) {

        double divisionResultToDouble = (double) a / b;
        int divisionResultToint = a / b;
        if (divisionResultToDouble != divisionResultToint) {
            throw new ArithmeticException("정수만 나눌 수 있습니다.");
        }
    }

    private void validate(int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }
}
