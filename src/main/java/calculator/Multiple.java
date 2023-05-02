package calculator;

public class Multiple implements Operation {
    @Override
    public int calculate(int preNumber, int postNumber) {
        return preNumber * postNumber;
    }
}
