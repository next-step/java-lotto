package calculate.domain;

public class Calculator {
    private Operands operands;
    private Delimiter delimiter;

    public Calculator(String s, String s1) {
        DelimiterStrategy delimiterStrategy = new DelimiterStrategy(s, s1);
        this.operands = delimiterStrategy.getOperands();
        this.delimiter = delimiterStrategy.getDelimiter();
    }

    public int calculate() {
        return operands.plusAll();
    }
}
