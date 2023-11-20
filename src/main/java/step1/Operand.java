package step1;

import java.util.regex.Pattern;

public class Operand {
    static Pattern pattern = Pattern.compile("\\d+");

    private Operand() {
    }

    public static boolean isOperand(String token) {

        return pattern.matcher(token).matches();
    }

    public static int operand(String token) {
        int result;
        try {
            result =  Integer.parseInt(token);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("invalid operand");
        }
        return result;
    }
}
