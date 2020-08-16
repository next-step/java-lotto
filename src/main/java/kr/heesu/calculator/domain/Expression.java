package kr.heesu.calculator.domain;

public class Expression {
    private final Arguments args;

    private final Result result;

    private Expression(Arguments args) {
        this.args = args;
        this.result = Result.of();
    }

    public boolean hasNextArgument() {
        return args.hasNext();
    }

    public void nextOperation() {
        this.result.plus(nextArgument());
    }

    public Result getResult() {
        return this.result;
    }

    private Number nextArgument() {
        return args.nextArgument();
    }

    public static Expression of(Arguments args) {
        return new Expression(args);
    }
}
