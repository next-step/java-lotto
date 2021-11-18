package calcalator.model;

import calcalator.strategy.DelimiterStrategy;

public class StringAddCalculator {

    private final Numbers numbers;
    private final DelimiterStrategy delimiterStrategy;

    public StringAddCalculator(String input, DelimiterStrategy delimiterStrategy) {
        this.delimiterStrategy = delimiterStrategy;
        this.numbers = new Numbers(split(input));
    }


    private String[] split(String input) {
        return this.delimiterStrategy.getToken(input);
    }


    public Number result() {
        return numbers.sum();
    }

}
