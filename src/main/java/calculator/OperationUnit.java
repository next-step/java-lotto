package calculator;

public class OperationUnit {
    private int left;
    private boolean isLeftSet;
    private String operand;
    private boolean isOperandSet;
    private int right;
    private boolean isRightSet;


    public OperationUnit() {
    }

    public OperationUnit(int left, String operand, int right) {
        checkSupportedOperand(operand);

        this.left = left;
        this.operand = operand;
        this.right = right;
    }

    private void checkSupportedOperand(String operand) {
        String[] supportedOperands = {"+", "-", "*", "/"};
        for (String supportedOperand : supportedOperands) {
            if (supportedOperand.equals(operand)) {
                return;
            }
        }

        throw new IllegalArgumentException("지원하지 않는 연산자 입니다. 입력 연산자:" + operand);
    }

    public void add(String element) {
        // element 가 정수인 경우
        if (isNumber(element)) {
            addNumber(Integer.parseInt(element));
            return;
        }

        // element 가 연산자인 경우
        addOperand(element);
    }

    private void addOperand(String operand) {
        if (isOperandSet) {
            return;
        }

        checkSupportedOperand(operand);

        this.operand = operand;
        isOperandSet = true;
    }

    private boolean isNumber(String element) {
        try {
            Integer.parseInt(element);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public void addNumber(int number) {
        if (isLeftSet) {
            this.right = number;
            this.isRightSet = true;
            return;
        }

        this.left = number;
        this.isLeftSet = true;
    }

    public boolean isCalculable() {
        return isLeftSet && isOperandSet && isRightSet;
    }

    public int getLeft() {
        return left;
    }

    public String getOperand() {
        return operand;
    }

    public int getRight() {
        return right;
    }

    public void initialize() {
        isLeftSet = false;
        isOperandSet = false;
        isRightSet = false;
    }
}
