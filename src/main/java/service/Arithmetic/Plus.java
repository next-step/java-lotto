package service.Arithmetic;

public class Plus implements Arithmetic {

    private static Plus instance;

    public static Plus getInstance() {
        if (instance == null) {
            instance = new Plus();
        }

        return instance;
    }

    private Plus() {}

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
