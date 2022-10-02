package lotto.domain;

public class SingleFormula {
    private final int number;
    private final String operator;
    private SingleFormula nextSingleFormula = null;

    public SingleFormula() {
        this.number = 0;
        this.operator = "+";
    }

    public SingleFormula(SingleFormulaVo singleFormulaVo) {
        this.number = singleFormulaVo.getNumber();
        this.operator = singleFormulaVo.getOperator();
    }

    public void setNextSingleFormula(SingleFormula nextSingleFormula) {
        this.nextSingleFormula = nextSingleFormula;
    }

    public void setLastSingleFormula(SingleFormula lastSingleFormula) {
        SingleFormula temp = this;
        while (temp.nextSingleFormula != null) {
            temp = temp.nextSingleFormula;
        }
        temp.nextSingleFormula = lastSingleFormula;
    }

    public int doOperate() {
        return doOperate(0);
    }

    public int doOperate(int initNumber) {
        int result = initNumber;

        if (this.operator.equals("+")) { result += number; }
        if (this.operator.equals("-")) { result -= number; }
        if (this.operator.equals("*")) { result *= number; }
        if (this.operator.equals("/")) { result /= number; }
        if (nextSingleFormula == null) { return result; }

        return nextSingleFormula.doOperate(result);
    }

}
