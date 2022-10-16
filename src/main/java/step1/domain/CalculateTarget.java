package step1.domain;

public class CalculateTarget {

    private final int firstOperand;
    private final String operator;
    private final int secondOperand;

    public CalculateTarget(int firstOperand, String operator, String secondOperand) {
        // 정수, 연산자 검증 및 int 변환
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = Integer.parseInt(secondOperand);
    }

    private int validation(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 지원하지 않습니다.");
        }
        return number;
    }

    public String getOperator() {
        return operator;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }
}
