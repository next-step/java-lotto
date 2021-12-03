package step1.calculator;

/**
 * .
 */
public class DefaultSplitString implements SplitString {
    @Override
    public String[] split(String input) {
        return input.split(",|:");
    }
}
