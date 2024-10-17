package stringcalculator;

public enum MathOperator {
    SUM("+") {
        @Override
        public int apply(int currentCalculationResult, int nextNumber) {
            return currentCalculationResult + nextNumber;
        }
    },
    DECREASE("-") {
        @Override
        public int apply(int currentCalculationResult, int nextNumber) {
            return currentCalculationResult - nextNumber;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public int apply(int currentCalculationResult, int nextNumber) {
            return currentCalculationResult * nextNumber;
        }
    },

    DIVISION("/") {
        @Override
        public int apply(int currentCalculationResult, int nextNumber) {
            return Math.floorDiv(currentCalculationResult, nextNumber);
        }
    };

    private final String operator;

    MathOperator(String operator) {
        this.operator = operator;
    }

    public static MathOperator selectOperator(String operator) {
        for (MathOperator mathOperator : values()) {
            if (mathOperator.operator.equals(operator)) {
                return mathOperator;
            }
        }
        return null;
    }

    public abstract int apply(int currentCalculationResult, int nextNumber);

}
