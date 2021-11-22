package calculator;

@FunctionalInterface
public interface Delimiter {
    String[] parse(final String text);
}
