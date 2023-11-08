package calculator;

public class Calculation {

    private Calculation(){
        throw new IllegalStateException("Utility Class");
    }


    public static int plus(int first, int second) {
        return first+second;
    }

    public static int subtract(int first, int second) {
        return first-second;
    }

    public static int multiply(int first, int second) {
        return first*second;
    }

    public static int divide(int first, int second) {
        return first/second;
    }
}
