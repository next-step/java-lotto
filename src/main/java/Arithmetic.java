import domain.ArithmeticSign;
import domain.Number;

public class Arithmetic {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public Number doArithmetic(Number first, Number second, ArithmeticSign sign) {
        if (sign.equals(new ArithmeticSign(PLUS))) {
            return add(first, second);
        }
        if (sign.equals(new ArithmeticSign(MINUS))) {
            return subtract(first, second);
        }
        if (sign.equals(new ArithmeticSign(MULTIPLICATION))) {
            return multiply(first, second);
        }
        if (sign.equals(new ArithmeticSign(DIVISION))) {
            return divide(first, second);
        }
        throw new IllegalArgumentException();
    }

    private Number add(Number a, Number b) {
        return new Number(a.getNumber() + b.getNumber());
    }

    private Number subtract(Number a, Number b) {
        return new Number(a.getNumber() - b.getNumber());
    }

    private Number multiply(Number a, Number b) {
        return new Number(a.getNumber() * b.getNumber());
    }

    private Number divide(Number a, Number b) {
        if (b.getNumber() == 0) {
            throw new IllegalArgumentException();
        }
        if (a.getNumber() * 1.0 / b.getNumber() % 1 != 0){
            throw new IllegalArgumentException();
        }
        return new Number(a.getNumber() / b.getNumber());
    }
}
