package calculator;

public record Calculator(int left, String operator, int right) {

    public int getString(int left, String operator, int right) {
        return switch (operator) {
            case "+" -> add(left, right);
            case "-" -> sub(left, right);
            case "*" -> mul(left, right);
            case "/" -> div(left, right);
            default -> throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        };
    }

    public int add(int left, int right) {
        return left + right;
    }

    public int sub(int left, int right) {
        return left - right;
    }

    public int mul(int left, int right) {
        return left * right;
    }

    public int div(int left, int right) {
        return left / right;
    }
}
