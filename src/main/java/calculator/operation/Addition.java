package calculator.operation;

public class Addition implements CustomOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort + rightPort;
    }
}
