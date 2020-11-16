package step01;

public class Int {
    public static boolean isParsed(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
