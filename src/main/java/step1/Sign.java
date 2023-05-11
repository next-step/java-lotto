package step1;

public enum Sign {
    PLUS("+")
    ,MINUS("-")
    ,MULTI("*")
    ,DIVIDE("/");

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
