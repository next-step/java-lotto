package stringCalculator.domain;

public class Calculation {

    private static int result = 0;

    public Calculation(){
    }

    public Calculation(int firstNumber) {
        result = firstNumber;
    }

    public static void plus(int number) {
        result = result + number;
    }

    public static void multiplication(int number) {
        result = result * number;
    }

    public static void minus(int number) {
        result = result - number;
    }

    public static void division(int number) {
        result = result / number;
    }

    @Override
    public String toString() { return "result :" + result;}
}
