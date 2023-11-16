package lotto;

public class LottoOperator {

    enum Operator {

        MINUS {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        MULTIPLY {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            public double apply(double x, double y) {
                if (y == 0) {
                    throw new IllegalArgumentException("Divisor cannot be zero.");
                }
                return x / y;
            }
        };

        public abstract double apply(double x, double y);
    }

    public double calculate(double num1, double num2, Operator operator) {
        return operator.apply(num1, num2);
    }

}
