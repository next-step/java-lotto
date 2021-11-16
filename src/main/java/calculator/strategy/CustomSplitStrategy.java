package calculator.strategy;

import calculator.DelimiterRegex;

public class CustomSplitStrategy implements SplitStrategy {

    @Override
    public String[] getSplitInput(String input, String delimiter) {
        return DelimiterRegex.getInput(input)
            .split(delimiter);
    }
}
