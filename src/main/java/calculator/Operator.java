package calculator;

public enum Operator {
    PLUS("+"){
        @Override
        public int apply(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-"){
        @Override
        public int apply(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        @Override
        public int apply(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        @Override
        public int apply(int num1, int num2) {
            return num1 / num2;
        }
    },
    ;

    private final String oper;

    Operator(String oper) {
        this.oper = oper;
    }
    public abstract int apply(int num1, int num2);

    public static Operator getOperator(String oper) {
        for(Operator op : Operator.values()) {
            if(op.oper.equals(oper)) {
                return op;
            }
        }
        throw new IllegalArgumentException("알 수 없는 연산입니다.");
    }
}
