package calculator.domain.operator;

public class OperatorFactory {

    public static Operator of(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
        }
        throw new IllegalArgumentException("지원하는 연산기호가 아닙니다.");
    }
}
