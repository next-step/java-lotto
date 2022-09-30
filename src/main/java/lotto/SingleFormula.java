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

    public int doOperate(int initNumber){
        int result = initNumber;
        if(this.operator.equals("+")){
            result += number;
        } else if(this.operator.equals("-")){
            result -= number;
        } else if(this.operator.equals("*")){
            result *= number;
        } else if(this.operator.equals("/")){
            result /= number;
        }

        if(nextSingleFormula == null){
            return result;
        }

        return nextSingleFormula.doOperate(result);
    }

}
