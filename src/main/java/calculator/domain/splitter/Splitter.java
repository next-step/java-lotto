package calculator.domain.splitter;

public interface Splitter {
    String[] split(String input);
    boolean isSupport(String input);
}
