package calculator.entity;

@FunctionalInterface
public interface OperationFormula {
    int result(int prevNumber, int number);
}
