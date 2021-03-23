package calculator;

public class PositiveNumber {

    private final int positiveNumber;

    public PositiveNumber(String positiveNumber) {
        this.positiveNumber = parseInt(positiveNumber);
    }

    private int parseInt(String positiveNumber) {
        try {
            int targetNum = Integer.parseInt(positiveNumber);
            if(targetNum < 0) {
                throw new RuntimeException();
            }
            return targetNum;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
