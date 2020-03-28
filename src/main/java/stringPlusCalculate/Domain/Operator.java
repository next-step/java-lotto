package stringPlusCalculate.Domain;

import java.util.List;

public enum Operator {

    PLUS {
        @Override
        double calc(List<Double> arithmeticTargets) {
            Double result = 0.0;
            for (Double arithmeticTarget : arithmeticTargets) {
                result += arithmeticTarget;
            }
            return result;
        }
    };

    abstract double calc(List<Double> arithmeticTargets);
}
