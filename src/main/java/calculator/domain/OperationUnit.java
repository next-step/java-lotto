package calculator.domain;

public class OperationUnit {
    private Operand left;
    private Operator operator;
    private Operand right;

    public OperationUnit() {
    }

    public OperationUnit(int left, String symbol, int right) {
        this.left = new Operand(left);
        this.operator = Operator.getOperatorBySymbol(symbol);
        this.right = new Operand(right);
    }

    public void add(String element) {
        if (left == null) {
            left = new Operand(element);
            return;
        }

        if (operator == null) {
            operator = Operator.getOperatorBySymbol(element);
            return;
        }

        if (right == null) {
            right = new Operand(element);
            return;
        }

        throw new IllegalStateException("연산 단위가 이미 완성되었습니다.");
    }

    public boolean isCalculable() {
        return left != null && operator != null && right != null;
    }

    public void calculate() {
        if (!isCalculable()) {
            throw new IllegalStateException("연산 단위가 완성되지 않았습니다.");
        }

        int left = this.left.getValue();
        int right = this.right.getValue();

        int result = operator.calculate(left, right);
        clear();
        passPreviousResult(result);
    }

    public int getResult() {
        if (left == null) {
            throw new IllegalStateException("결과값이 존재하지 않습니다.");
        }
        return left.getValue();
    }

    private void clear() {
        left = null;
        operator = null;
        right = null;
    }

    private void passPreviousResult(int result) {
        left = new Operand(result);
    }
}
