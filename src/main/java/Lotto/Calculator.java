package lotto;

public class Calculator {
    private static final String INVALID_INPUT = "유효하지 않은 입력값입니다.";

    public static void main(String[] args) {
        int result = Calculator.calculate(InputView.inputCalculation());
        ResultView.print(result);
    }

    public static int calculate(String valueText) {
        if (valueText == null || valueText.isBlank()) throw new IllegalArgumentException(INVALID_INPUT);

        String[] values = valueText.split(" ");
        int result = toNumber(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            Operator operator = Operator.operatorOf(values[i]);
            int number = toNumber(values[i + 1]);

            result = operator.operate(result, number);
        }

        return result;
    }

    private static int toNumber(String value) {
        if (value.isBlank()) throw new IllegalArgumentException(INVALID_INPUT);
        return Integer.parseInt(value);
    }
}
