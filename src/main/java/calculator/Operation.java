package calculator;

public enum Operation implements Calculate{
    PLUS('+') {
        @Override
        public int calculate(int i, int j) {
            return i + j;
        }
    },
    MINUS('-') {
        @Override
        public int calculate(int i, int j) {
            return i - j;
        }
    },
    TIMES('*') {
        @Override
        public int calculate(int i, int j) {
            return i * j;
        }
    },
    DIVISION('/') {
        @Override
        public int calculate(int i, int j) {
            return i / j;
        }
    };

    private Character operation;

    Operation(Character operation) {
        this.operation = operation;
    }


}
