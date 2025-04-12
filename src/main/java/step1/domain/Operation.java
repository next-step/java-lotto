package step1.domain;

@FunctionalInterface
public interface Operation {
    Number operate(Number left, Number right);
}
