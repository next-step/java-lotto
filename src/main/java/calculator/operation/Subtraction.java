package calculator.operation;

public class Subtraction implements CustomOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort - rightPort;
    }
}
