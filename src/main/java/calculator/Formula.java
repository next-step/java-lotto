package calculator;

import data.Messages;

public class Formula {

    private final String formula;

    private static final String PREFIX = "+ ";

    public Formula(String formula){
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
        this.formula = formula;
    }

    public String[] getCalculateTarget(){
        return PREFIX.concat(formula).split(" ");
    }
}
