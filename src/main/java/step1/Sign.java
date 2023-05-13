package step1;

import step1.CalculateStratety.Plus;

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

    public static String signRegexString(){
        String signs = "[";
        Sign[] values = Sign.values();
        for (Sign value : values) {
            signs += "\\";
            signs += value.getSign();
        }
        signs += "]";
        return signs;
    }
}
