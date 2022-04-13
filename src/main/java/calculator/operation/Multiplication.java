package calculator.operation;

public class Multiplication implements CustomOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort * rightPort;
    }
}
