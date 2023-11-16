package calculator.domain.operator;

public class OperatorFactory {

    public static Operator of(String operator) {
        switch (operator) {
            case "+":
                return Integer::sum;
            case "-":
                return (num1, num2) -> num1 - num2;
            case "*":
                return (num1, num2) -> num1 * num2;
            case "/":
                return (num1, num2) -> {
                    validateDivision(num1, num2);
                    return num1 / num2;
                };
        }
        throw new IllegalArgumentException("지원하는 연산기호가 아닙니다.");
    }

    private static void validateDivision(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
        }
    }


}
