package study.step1.domain.type;

public enum Operator {
    PLUS("+", "더하기"),
    MINUS("-", "빼기"),
    TIMES("*", "곱하기"),
    DIVIDE("/", "나누기");

    private final String code;
    private final String message;

    Operator(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public static Operator valueOfCode(String code) {
        for (Operator operator: values()) {
            if (code.equals(operator.getCode())) {
                return operator;
            }
        }
        return null;
    }
}
