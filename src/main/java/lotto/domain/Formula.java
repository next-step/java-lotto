package lotto.domain;

public class Formula {
    private static final String SEPARATOR = " ";
    private SingleFormula firstSingleFormula = new SingleFormula();

    public Formula(String formulaString) {
        checkValidation(formulaString);
        makeFirstSingFormula(split(formulaString));
    }

    private void checkValidation(String formulaString) {
        if (formulaString == null || formulaString.trim().length() == 0) {
            throw new IllegalArgumentException("Wrong Input");
        }
    }

    public SingleFormula getFirstSingleFormula() {
        return firstSingleFormula;
    }

    private void makeFirstSingFormula(String[] elementArray) {
        SingleFormulaVo tempSingleFormulaVo = new SingleFormulaVo();
        for (String element : elementArray) {
            connectSingleFormula(tempSingleFormulaVo, element);
        }
    }

    private void connectSingleFormula(SingleFormulaVo SingleFormulaVo, String element) {
        SingleFormulaVo.set(element);
        if (SingleFormulaVo.isValid()) {
            firstSingleFormula.setLastSingleFormula(new SingleFormula(SingleFormulaVo));
            SingleFormulaVo.reset();
        }
    }

    private String[] split(String formulaString) {
        return formulaString.split(SEPARATOR);
    }

}
