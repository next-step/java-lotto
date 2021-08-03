package adder;

import java.util.List;
import java.util.stream.Collectors;

public class StringAdder {

    public int splitAndSum(String input) {
        return getPositiveNumbers(new Expression(input)).stream()
                .reduce(PositiveNumber.ZERO, PositiveNumber::sum)
                .toInt();
    }

    public List<PositiveNumber> getPositiveNumbers(Expression expression) {
        return getTokenizeStrategy(expression).split(expression)
                .stream()
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    private TokenizeStrategy getTokenizeStrategy(Expression expression) {
        return CustomTokenizeStrategy.containCustomDelimiter(expression)
                ? new CustomTokenizeStrategy()
                : new DefaultTokenizeStrategy();
    }
}
