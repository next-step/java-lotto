package addcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {
    private SplitStrategy splitStrategy;

    public StringAddCalculator(SplitStrategy splitStrategy){
        this.splitStrategy = splitStrategy;
    }


    public int calculate(String inputValue) {
        String[] splitValue = splitStrategy.split(emptyInputCheck(inputValue));
        return Arrays.stream(splitValue).mapToInt(i -> Integer.parseInt(i)).sum();
    }

    private String emptyInputCheck(String inputValue) {
        String returnInputValue = inputValue;
        if(inputValue == null || inputValue.trim().length() == 0){
            returnInputValue = "0";
        }
        return returnInputValue;
    }
}
