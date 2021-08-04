package adder;

import java.util.List;
import java.util.stream.Collectors;

public class StringAdder {

    public int splitAndSum(String input) {
        return getPositiveNumbers(new Expression(input)).stream()
                .reduce(PositiveNumber.ZERO, PositiveNumber::sum)
                .toInt();
    }

    private List<PositiveNumber> getPositiveNumbers(Expression expression) {
        return TokenizeStrategyFactory.getTokenizeStrategy(expression)
                .split(expression)
                .stream()
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

}
