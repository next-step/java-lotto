package calculator;

@FunctionalInterface
public interface Operation {
  int operate(int a, int b);
}
