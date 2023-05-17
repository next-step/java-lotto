package study.enums;

public enum Operation {
    PLUS("+") {
        public int calculate(int x, int y) {
            return Math.addExact(x, y);
        }
    },
    MINUS("-") {
        public int calculate(int x, int y) {
            return Math.subtractExact(x, y);
        }
    },
    MULTIPLY("*") {
        public int calculate(int x, int y) {
            return Math.multiplyExact(x, y);
        }
    },
    DIVISION("/") {
        public int calculate(int x, int y) {
            return Math.floorDiv(x, y);
        }
    };

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract int calculate(int x, int y);

    public static Operation findBy(String operationText) {
        for (Operation op : Operation.values()) {
            if (op.symbol.equals(operationText)) {
                return op;
            }
        }

        throw new IllegalArgumentException("유효하지 않은 연산입니다");
    }

}
