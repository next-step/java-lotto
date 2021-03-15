package study.calculator.pattern;

@FunctionalInterface
public interface PatternSeparator {
    String[] matches(String text);
}
