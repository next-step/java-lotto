package calculcator;

public enum Operator {
    ADDITION {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACTION {
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLICATION {
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVISION {
        public int apply(int x, int y) {
            return x / y;
        }
    };

    public abstract int apply(int x, int y);
}
