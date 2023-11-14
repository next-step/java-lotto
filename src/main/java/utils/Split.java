package utils;

public class Split {

    private static final String PATTERN = " ";

    private Split() { //인스턴스화 방지
    }

    public static String[] splitByPattern(String input) {
        return input.split(PATTERN);
    }
}
