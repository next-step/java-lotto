package service.Arithmetic;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("더하기", (a, b) -> (a + b)),
    MINUS("빼기", (a, b) -> (a - b)),
    MULTIPLY("곱하기", (a, b) -> (a * b)),
    DIVIDE("나누기") {
        public int calculate(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            int result = a / b;

            if (a % b != 0) {
                throw new ArithmeticException("두 수의 나눗셈 결과가 정수가 아닙니다.");
            }
            return result;
        }
    };

    private final String name;
    private BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String name, BiFunction<Integer, Integer, Integer> biFunction) {
        this.name = name;
        this.biFunction = biFunction;
    }

    Operator(String name) {
        this.name = name;
    }

    public int calculate(int a, int b) {
        return this.biFunction.apply(a, b);
    }
}
