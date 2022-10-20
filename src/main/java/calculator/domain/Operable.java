package calculator.domain;

@FunctionalInterface
public interface Operable {

    int operate(int first, int second);
}
