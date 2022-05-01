package calculator;

public class Calculator {

    public Calculator() {
    }

    int plus(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    int minus(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    int multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    int divide(String a, String b) {
        return Integer.parseInt(a) / Integer.parseInt(b);
    }
}
