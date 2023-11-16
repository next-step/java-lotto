package util;

public class ArithmeticSplit {

    private static final String PATTERN = " ";

    private ArithmeticSplit() { //인스턴스화 방지
    }

    public static String[] splitByPattern(String input) {
        return input.split(PATTERN);
    }
}
