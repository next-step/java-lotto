package stringcalculator;

public enum Operation {
    PLUS("+"){
        public double apply(double a, double b) {
            return a+b;
        }
    },
    MINUS("-"){
        public double apply(double a, double b) {
            return a-b;
        }
    },
    MULTIPLY("*"){
        public double apply(double a, double b) {
            return a*b;
        }
    },
    DIVIDE("/"){
        public double apply(double a, double b) {
            return a/b;
        }
    };

    Operation(String symbol) {
    }

    public abstract double apply(double a, double b);
}
