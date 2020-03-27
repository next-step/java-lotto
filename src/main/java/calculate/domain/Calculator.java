package calculate.domain;

public class Calculator {
    private Operands operands;
    private Delimiter delimiter;

    public Calculator(String operandString, String delimiter) {
        DelimiterStrategy delimiterStrategy = new DelimiterStrategy(operandString, delimiter);
        this.operands = delimiterStrategy.getOperands();
        this.delimiter = delimiterStrategy.getDelimiter();
    }

    public int calculate() {
        return operands.plusAll();
    }
}
