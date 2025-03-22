package calculator.domain;

public class OperationUnit {
    private Operand left;
    private Operator operator;
    private Operand right;

    public OperationUnit() {
    }

    public OperationUnit(int left, String operator, int right) {
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
        if (Operator.isSupportedOperator(element)) {
            addOperator(element);
        }
    }

    public boolean isCalculable() {
        return left != null && operator != null && right != null;
    }

    public void calculate() {
        if (isCalculable()) {
            int left = getLeft();
            String operator = getOperator();
            int right = getRight();

            int result = Calculator.calculate(left, operator, right);

            clear();

            passPreviousResult(result);
        }
    }

    public int getResult() {
        return getLeft();
    }

    private void addOperand(Integer input) {
        if (isNotSet(left)) {
            left = new Operand(input);
            return;
        }

        right = new Operand(input);
    }

    private void addOperator(String input) {
        if (isNotSet(operator)) {
            operator = new Operator(input);
        }
    }

    private void clear() {
        left = null;
        operator = null;
        right = null;
    }

    private boolean isNotSet(Object object) {
        return object == null;
    }

    private void passPreviousResult(int result) {
        left = new Operand(result);
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
