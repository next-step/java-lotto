package calculate.domain;

public class Executor {

    private Expression expression;

    public Executor(String input) {
        this(new Expression(input));
    }

    public Executor(Expression expression) {
        this.expression = expression;
    }
}
