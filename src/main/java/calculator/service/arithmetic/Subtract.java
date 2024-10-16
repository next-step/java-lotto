package calculator.service.arithmetic;

public class Subtract implements Arithmetic {

    private static Subtract instance;

    public static Subtract getInstance() {
        if (instance == null) {
            instance = new Subtract();
        }

        return instance;
    }

    private Subtract() {}

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
