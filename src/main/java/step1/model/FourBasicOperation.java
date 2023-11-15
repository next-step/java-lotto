package step1.model;

import step1.enumeration.OperatorTypes;

public class FourBasicOperation {

    private static final int INDEX_OF_NUMBER = 2;

    private final String formula;

    public FourBasicOperation(String formula) {
        this.formula = formula;
    }

    public int run() {
        String[] formulaInputList = new ConvertFormulaString(formula).get();
        int result = Integer.parseInt(formulaInputList[0]);

        for (int i = INDEX_OF_NUMBER; i < formulaInputList.length; i = i+ INDEX_OF_NUMBER) {
            result = OperatorTypes.calculate(result, Integer.parseInt(formulaInputList[i]), formulaInputList[i-1]);
        }

        return result;
    }
}
