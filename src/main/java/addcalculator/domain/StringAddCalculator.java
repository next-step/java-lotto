package addcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String OPERAND_PATTERN = "(\\d+)";

    private SplitStrategy splitStrategy;

    public StringAddCalculator(SplitStrategy splitStrategy){
        this.splitStrategy = splitStrategy;
    }

    public int calculate(String inputValue) {
        String[] splitValue = splitStrategy.split(emptyInputCheck(inputValue));
        return Arrays.stream(splitValue).mapToInt(input -> validateInputValue(input)).sum();
    }

    private int validateInputValue(String input) {
        if(!input.matches(OPERAND_PATTERN)){
            throw new RuntimeException();
        }
        return Integer.parseInt(input);
    }

    private String emptyInputCheck(String inputValue) {
        String returnInputValue = inputValue;
        if(inputValue == null || inputValue.trim().length() == 0){
            returnInputValue = "0";
        }
        return returnInputValue;
    }

}
