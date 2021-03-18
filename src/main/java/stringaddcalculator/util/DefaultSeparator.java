package stringaddcalculator.util;

public class DefaultSeparator implements Separator {
    @Override
    public String[] splitExpression(String expression) {
        return new String[]{""};
    }
}
