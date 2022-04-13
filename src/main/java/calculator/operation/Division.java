package calculator.operation;

public class Division implements CustomOperation {

    @Override
    public int calculate(int leftPort, int rightPort) {
        if (rightPort == 0) {
            throw new IllegalArgumentException("0으로 나눌 수는 없습니다!");
        }
        return leftPort / rightPort;
    }
}
