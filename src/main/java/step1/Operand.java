package step1;

public class Operand {

    public static boolean isOperand(String token) {
        return token.matches("\\d+");
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

    private Operand() {
    }
}
