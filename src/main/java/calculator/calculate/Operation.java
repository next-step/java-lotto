package calculator.calculate;

@FunctionalInterface
public interface Operation {
    int apply(int a, int b);
}
