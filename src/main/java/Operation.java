
public enum Operation {
    ADD("+") {
        public int apply(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACT("-") {
        public int apply(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        public int apply(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        public int apply(int number1, int number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return number1 / number2;
        }
    };

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperationByElement(String element) {
        if ("+".equals(element)) {
            return Operation.ADD;
        } else if ("-".equals(element)) {
            return Operation.SUBTRACT;
        } else if ("*".equals(element)) {
            return Operation.MULTIPLY;
        }
        return Operation.DIVIDE;
    }

    public abstract int apply(int number1, int number2);
}
