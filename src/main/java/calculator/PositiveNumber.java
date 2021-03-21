package calculator;

public class PositiveNumber {

    private final int positiveNumber;

    public PositiveNumber(String positiveNumber) {
        this.positiveNumber = parseInt(positiveNumber);
    }

    private int parseInt(String positiveNumber) {
        int targetNum;
        try {
            targetNum = Integer.parseInt(positiveNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        if(targetNum<0) {
            throw new RuntimeException();
        }
        return targetNum;
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
