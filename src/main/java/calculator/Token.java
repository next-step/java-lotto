package calculator;

public abstract class Token {

    public static Token of(String token) {
        if (isNumeric(token)) {
            return new Operand(Integer.parseInt(token));
        }
        return Operator.from(token);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
