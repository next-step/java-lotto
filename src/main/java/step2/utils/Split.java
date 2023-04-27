package step2.utils;

public class Split {

    private static final String DELIMITER = ",";

    private Split() {
    }

    public static String[] getStrings(String str) {
        return str.split(DELIMITER);
    }
}
