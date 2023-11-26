package calculator;

public class StringCalculator {

    public static String[] getSplit(String text) {
        String[] split = text.split(" ");
        return split;
    }

    public static int plus(String text) {
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
        return result;
    }

    public static int minus(String text) {
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) - Integer.parseInt(split[2]);
        return result;
    }

}
