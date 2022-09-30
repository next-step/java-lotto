package lotto;

public class SingleFormula {
    private final int number;
    private final String operator;
    private SingleFormula nextSingleFormula = null;

    public SingleFormula(int number, String operator){
        this.number = number;
        this.operator = operator;
    }

    public void setNextSingleFormula(SingleFormula nextSingleFormula) {
        this.nextSingleFormula = nextSingleFormula;
    }

    // 미완
    public int doOperate(int initNumber){
        return initNumber;
    }
}
