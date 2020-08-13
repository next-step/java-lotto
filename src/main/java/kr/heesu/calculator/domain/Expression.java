package kr.heesu.calculator.domain;

public class Expression {
    private final Arguments args;
    private final Operator operator;

    private Expression(Arguments args) {
        this.args = args;
        this.operator = Operator.of();
    }

    public boolean hasNextArgument() {
        return args.hasNext();
    }

    public int nextOperation(int result) {
        return operator.operate(result, nextArgument());
    }

    public int nextArgument() {
        return args.nextArgument();
    }

    public static Expression of(Arguments args) {
        return new Expression(args);
    }
}
