package calculator.operation;

public class Division implements CustomOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        return leftPort / rightPort;
    }
}
