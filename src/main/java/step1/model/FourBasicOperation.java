package step1.model;

import step1.enumeration.OperatorTypes;
import step1.model.calculate.*;

public class FourBasicOperation {

    private final String formula;

    public FourBasicOperation(String formula) {
        this.formula = formula;
    }

    public int run() {
        String[] formulaInputList = new ConvertFormulaString(formula).get();
        int result = Integer.parseInt(formulaInputList[0]);

        for (int i=2; i < formulaInputList.length; i = i+2) {
            result = calculate(result, Integer.parseInt(formulaInputList[i]), formulaInputList[i-1]);
        }

        return result;
    }

    private int calculate(int result, int number, String operator) {
        if (OperatorTypes.PLUS.getOperator().equals(operator)) {
            Calculate plus = new PlusCalculate();
            return plus.operate(result, number);
        }

        if (OperatorTypes.TAKE_OUT.getOperator().equals(operator)) {
            Calculate takeOut = new TakeOutCalculate();
            return takeOut.operate(result, number);
        }

        if (OperatorTypes.MULTIPLY.getOperator().equals(operator)) {
            Calculate multiply = new MultiplyCalculate();
            return multiply.operate(result, number);
        }

        if (OperatorTypes.DIVISION.getOperator().equals(operator)) {
            Calculate division = new DivisionCalculate();
            return division.operate(result, number);
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
