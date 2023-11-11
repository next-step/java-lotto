package calculator.domain;

public enum Operation implements Calculate {
    PLUS("+") {
        @Override
        public int calculate(int i, int j) {
            return i + j;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int i, int j) {
            return i - j;
        }
    },
    TIMES("*") {
        @Override
        public int calculate(int i, int j) {
            return i * j;
        }
    },
    DIVISION("/") {
        @Override
        public int calculate(int i, int j) {
            return i / j;
        }
    };

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static boolean isOperation(String token) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equals(token)) {
                return true;
            }
        }

        return false;
    }

    public static Operation fromString(String token) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equals(token)) {
                return operation;
            }
        }

        return null;
    }


}
