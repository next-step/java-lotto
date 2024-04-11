package calculator.calc;

import java.util.Arrays;

public enum Operator {
    ADDITION("+") {
        @Override
        public int apply(int firstOperand, int secondOperand){
            return firstOperand +  secondOperand;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int apply(int firstOperand, int secondOperand){
            return firstOperand -  secondOperand;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(int firstOperand, int secondOperand){
            return firstOperand / secondOperand;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(int firstOperand, int secondOperand){
            return firstOperand *  secondOperand;
        }
    };


    private final String textOperator;

    Operator(String operator) {
        this.textOperator = operator;
    }

    public abstract int apply(int firstOperand, int secondOperand);

    public static Operator of(String symbol){
        return Arrays.stream(values())
                .filter(operator -> operator.isTextOperator((symbol)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을 수 없습니다."));
    }

    private boolean isTextOperator(String symbol){
        return this.textOperator.equals(symbol);
    }
}
