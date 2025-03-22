package calculator;

public class OperationUnit {
    private Operand left;
    private Operand right;
    private Operator operator;

    public OperationUnit() {
    }

    public OperationUnit(Integer left, String operator, Integer right) {
        this.left = new Operand(left);
        this.operator = new Operator(operator);
        this.right = new Operand(right);
    }

    public void add(String element) {
        // element 가 정수인 경우
        if (Operand.isNumber(element)) {
            addOperand(Integer.parseInt(element));
            return;
        }

        // element 가 연산자인 경우
        Operator.checkSupportedOperator(element);
        addOperator(element);
    }

    private void addOperand(Integer operand) {
        if (this.left == null) {
            this.left = new Operand(operand);
            return;
        }

        this.right = new Operand(operand);
    }

    private void addOperator(String operator) {
        if (this.operator == null) {
            this.operator = new Operator(operator);
        }
    }

    public boolean isCalculable() {
        return left != null && operator != null && right != null;
    }

    public void clear() {
        left = null;
        operator = null;
        right = null;
    }

    public void passPreviousResult(int result) {
        left = new Operand(result);
    }

    public int getResult() {
        return getLeft();
    }

    public int getLeft() {
        return left.getValue();
    }

    public int getRight() {
        return right.getValue();
    }

    public String getOperator() {
        return operator.getValue();
    }
}
