package StringCalculator;

public class Number {
    public final static String REG_EXP = "^[0-9]+$";
    private final int value;

    public Number(String value) {
        validation(value);
        this.value = toInteger(value);
    }

    public void validation(String value) {
        if (isMinus(value))
            throw new RuntimeException("음수는 들어올 수 없습니다.");
        if (isDisallowedString(value))
            throw new IllegalArgumentException("숫자 이외의 문자 값이 들어올 수 없습니다.");
    }

    public static boolean isDisallowedString(String value){
        return !value.matches(REG_EXP);
    }

    public static boolean isMinus(String value) {
        return toInteger(value) < 0;
    }

    public static int toInteger(String value) {
        return Integer.parseInt(value.trim());
    }

    public int getValue(){
        return value;
    }
}
