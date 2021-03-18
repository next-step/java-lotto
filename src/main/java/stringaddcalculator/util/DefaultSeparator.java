package stringaddcalculator.util;

public class DefaultSeparator implements Separator {
    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String[] splitExpression(String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }
}
