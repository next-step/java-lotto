package study.calculator;

@FunctionalInterface
public interface PatternSeparator {
    String[] matches(String text);
}
