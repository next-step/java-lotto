package calculator.entity;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Expressions {

    private final List<CalculateExpression> expressions;

    public Expressions() {
        expressions = Stream.of(CalculateExpression.values()).collect(Collectors.toList());
    }

    public CalculateExpression findExpression(String expression) {
        return this.expressions.stream().filter(i -> i.isMatch(expression)).findFirst().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부호"));
    }

}
