package stringcalcaulator.domain.token;

import stringcalcaulator.domain.ExpressionTokenVisitor;

public enum OperatorToken implements ExpressionToken {
    ADD("+") {
        @Override
        public OperandToken calculate(OperandToken token1, OperandToken token2) {
            return token1.add(token2);
        }
    },
    SUB("-") {
        @Override
        public OperandToken calculate(OperandToken token1, OperandToken token2) {
            return token1.sub(token2);
        }
    },
    MUL("*") {
        @Override
        public OperandToken calculate(OperandToken token1, OperandToken token2) {
            return token1.mul(token2);
        }
    },
    DIV("/") {
        @Override
        public OperandToken calculate(OperandToken token1, OperandToken token2) {
            return token1.div(token2);
        }
    },
    ;

    private final String symbol;

    public boolean isMatchSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }

    OperatorToken(String symbol) {
        this.symbol = symbol;
    }

    public abstract OperandToken calculate(OperandToken token1, OperandToken token2);

    @Override
    public void accept(ExpressionTokenVisitor visitor) {
        visitor.visit(this);
    }
}
