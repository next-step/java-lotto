package stringadder;

public class Converter {
    private static final int THRESHOLD = 0;

    public static int toInt(String s) {
        int num = Integer.parseInt(s);
        if (num < THRESHOLD) {
            throw new RuntimeException();
        }
        return num;
    }
}
