package calculate.domain;

public class Calculator {
    private Operands operands;
    private Delimiter delimiter;

    public Calculator(String primalOperand, String delimiter) {
        DelimiterStrategy delimiterStrategy = new DelimiterStrategy(primalOperand, delimiter);
        this.operands = delimiterStrategy.getOperands();
        this.delimiter = delimiterStrategy.getDelimiter();
    }

    public int calculate() {
        return operands.plusAll();
    }
}
