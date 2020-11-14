package addcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {
    private SplitStrategy splitStrategy;

    public StringAddCalculator(SplitStrategy splitStrategy){
        this.splitStrategy = splitStrategy;
    }


    public int calculate(String inputValue) {
        String[] splitValue = splitStrategy.split(inputValue);
        return Arrays.stream(splitValue).mapToInt(i -> Integer.parseInt(i)).sum();
    }
}
