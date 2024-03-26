package calculator;

public enum MathSign {
    PLUS ("+"),
    MINUS ("-"),
    MULTIPLY ("*"),
    DIVIDE ("/");

    private final String sign;

    MathSign(String sign) {
        this.sign = sign;
    }

    public String sign(){
        return this.sign;
    }
}
