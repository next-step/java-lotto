package calculator;

public interface ArithmeticOperation {
    static ArithmeticOperation sign(String sign) {
        if ("+".equals(sign)) {
            return new Plus();
        }
        if ("-".equals(sign)) {
            return new Minus();
        }
        if ("*".equals(sign)) {
            return new Multi();
        }
        if ("/".equals(sign)) {
            return new Divide();
        }
        throw new IllegalArgumentException("사칙연산 부호가 아닙니다!");
    }

    Number calculate(Number number1, Number number2);
}
