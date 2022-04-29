package step1;

public class StringCalculator {

    private final Input input;

    public StringCalculator(String text) {
        this.input = new Input(text);
    }

    public int calculate() {

        int result = input.getFirstOperand();

        for (int i = 0; i < input.getOperationBundleCount(); i++) {
            Operator operator = input.getOperator();
            int operand = input.getOperand();
            result = operator.operate(result, operand);
        }

        return result;
    }
}
