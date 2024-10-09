package calculator.entity;

public enum CalculateExpression {
    ADD("+",(prevNumber,number)->prevNumber+number),
    SUBTRACT("-",(prevNumber,number)->prevNumber-number),
    MULTIPLY("*",(prevNumber,number)->prevNumber*number),
    DIVIDE("/",(prevNumber,number)->prevNumber/number);

    private String expression;
    private OperationFormula operationFormula;

    CalculateExpression(String expression, OperationFormula operationFormula){
        this.expression = expression;
        this.operationFormula = operationFormula;
    }

    int result(int prevNumber, int number){
        return this.operationFormula.result(prevNumber,number);
    }

    public boolean isMatch(String expression) {
        return this.expression.equals(expression);
    }
}
