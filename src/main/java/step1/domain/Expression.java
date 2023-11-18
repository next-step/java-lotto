package step1.domain;

public class Expression {

    private final String[] tokens;

    public Expression(final String[] tokens) {
        validateTokens(tokens);
        this.tokens = tokens;
    }

    private void validateTokens(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("식이 올바르게 입력되지 않았습니다.");
        }
    }

    public Operand calculate() {
        Operand resultOperand = Operand.of(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.find(tokens[i]);
            Operand operand = Operand.of(tokens[i + 1]);

            resultOperand = operator.calculate(resultOperand, operand);
        };

        return resultOperand;
    }

}
