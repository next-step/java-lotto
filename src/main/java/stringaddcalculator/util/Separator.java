package stringaddcalculator.util;

@FunctionalInterface
public interface Separator {
    String[] splitExpression(String expression);
}
