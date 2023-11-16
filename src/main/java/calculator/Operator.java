package calculator;

public enum Operator implements CalculateInterface{
    ADD("+") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    };

    private String operator;
    Operator(String operator) {
        this.operator = operator;
    }

    public String operator() {
        return this.operator;
    }
}
