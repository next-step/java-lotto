package step1.domain;

public class CalculateTarget {

    private final int firstNum;
    private final String operator;
    private final int secondNum;

    public CalculateTarget(int firstNum, String operator, String secondNum) {
        // 정수, 연산자 검증 및 int 변환
        this.firstNum = firstNum;
        this.operator = operator;
        this.secondNum = Integer.parseInt(secondNum);
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

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }
}
