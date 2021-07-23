package calculator;

@FunctionalInterface
public interface Splitter {
    SplitNumber split(String str);
}
