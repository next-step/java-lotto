package StringCalculator.domain;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }


    public static Operator from(String input) {
        for (Operator operator : Operator.values()) {
            if (operator.getSign().equals(input)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("not admit operator : " + input);
    }


}

