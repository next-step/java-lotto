package calculator;

public class Calculator {
    private final String expr;

    public Calculator(String expr) {
        if (expr == null || expr.isBlank()) {
            throw new IllegalArgumentException("should not null or empty string");
        }
        this.expr = expr;
    }

    public int calculate() {
        String[] splits = expr.split(" ");
        int lhs = Integer.parseInt(splits[0]);
        for (int i = 1; i < splits.length; i += 2) {
            Operator operator = OperatorFactory.create(splits[i]);
            int rhs = Integer.parseInt(splits[i + 1]);

            lhs = operator.calculate(lhs, rhs);
        }

        return lhs;
    }
}
