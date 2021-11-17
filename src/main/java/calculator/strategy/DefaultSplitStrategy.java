package calculator.strategy;

public class DefaultSplitStrategy implements SplitStrategy {

    @Override
    public String[] getSplitInput(String input, String delimiter) {
        return input.split(delimiter);
    }
}
