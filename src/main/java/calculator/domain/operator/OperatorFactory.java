package calculator.domain.operator;

public class OperatorFactory {

    public static Operator of(String operator) {
        OperatorType type = OperatorType.of(operator);
        switch (type) {
            case ADDITION:
                return Integer::sum;
            case SUBTRACTION:
                return (num1, num2) -> num1 - num2;
            case MULTIPLICATION:
                return (num1, num2) -> num1 * num2;
            case DIVISION:
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
