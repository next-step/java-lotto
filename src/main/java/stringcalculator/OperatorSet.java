package stringcalculator;

import java.util.HashSet;

public class OperatorSet {

    private final HashSet<String> operatorSet;

    public OperatorSet(HashSet<String> operatorSet) {
        this.operatorSet = operatorSet;
    }

    public HashSet<String> getOperatorSet() {
        return operatorSet;
    }
}