package calculator.strategy;

@FunctionalInterface
public interface SplitStrategy {

    String[] getSplitInput(String input, String delimiter);

}
