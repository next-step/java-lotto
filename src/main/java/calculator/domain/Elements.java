package calculator.domain;

public class Elements extends Operator {

    private final String[] targets;

    public Elements(String[] targets) {
        for (int i = 1; i < targets.length; i += 2) {
            String operator = targets[i];
            validateOperator(operator);
        }
        this.targets = targets;
    }

    private void validateOperator(String operator) {
        if (isWrongOperator(operator)) {
            throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
        }
    }

    private boolean isWrongOperator(String strings) {
        return !(
            strings.equals(ADD_OPERATOR)
                || strings.equals(SUBTRACT_OPERATOR)
                || strings.equals(MULTIPLY_OPERATOR)
                || strings.equals(DIVIDE_OPERATOR)
        );
    }

    public String getFirstOperand() {
        return targets[0];
    }

    public int getSize() {
        return targets.length;
    }

    public String getOperator(int i) {
        return targets[i];
    }

    public String getOperand(int i) {
        return targets[i];
    }
}
