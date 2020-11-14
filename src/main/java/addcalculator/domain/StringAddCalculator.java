package addcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String ILLEGAL_OPERAND_ERROR_MESSAGE = "피연산자는 정수형 숫자로 입력하세요.";
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
            throw new IllegalArgumentException(ILLEGAL_OPERAND_ERROR_MESSAGE);
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
