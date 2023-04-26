package stringcalculator.domain;

@FunctionalInterface
public interface OperatorInterface {

  int operate(int leftInt, int rightInt);
}
