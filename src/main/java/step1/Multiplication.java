package step1;

public class Multiplication implements Operator {
    @Override
    public int apply(int x, int y) {
        return x * y;
    }
}
