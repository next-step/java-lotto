package stringaddcalculator.util;

public class CustomSeparator implements Separator {
    @Override
    public String[] splitExpression(String expression) {
        return new String[]{""};
    }
}
