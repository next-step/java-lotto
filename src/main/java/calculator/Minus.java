package calculator;

public class Minus implements Operation {
    @Override
    public int calculate(int preNumber, int postNumber) {
        return preNumber - postNumber;
    }
}
