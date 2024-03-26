package calculator.code;

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

    public static MathSign fromSign(String sign) {
        if (sign.equals(MathSign.PLUS.sign()))
            return MathSign.PLUS;
        if (sign.equals(MathSign.MINUS.sign()))
            return MathSign.MINUS;
        if (sign.equals(MathSign.MULTIPLY.sign()))
            return MathSign.MULTIPLY;
        if (sign.equals(MathSign.DIVIDE.sign()))
            return MathSign.DIVIDE;
        throw new IllegalArgumentException("올바르지 않은 연산 기호입니다.");
    }

}
