package stringCalculator.domain;

public class StringCalculator {


    public int plus(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public int minus(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    public int multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    public int divide(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }
}
