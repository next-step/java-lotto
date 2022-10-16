package StringCalculator.backend.domain;

@FunctionalInterface
public interface Operator {
    int calculate(Operand x, Operand y);
}
