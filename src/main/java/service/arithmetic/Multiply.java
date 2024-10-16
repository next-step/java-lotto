package service.arithmetic;

public class Multiply implements Arithmetic {

    private static Multiply instance;

    public static Multiply getInstance() {
        if (instance == null) {
            instance = new Multiply();
        }

        return instance;
    }

    private Multiply() {}

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
