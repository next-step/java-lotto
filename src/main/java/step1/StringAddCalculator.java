package step1;

public class StringAddCalculator {

    private static final String delimiter = ",";

    private static boolean checkNull(String str) {
        return str == null;
    }

    private static boolean checkEmpty(String str) {
        return str.isEmpty();
    }

    private static boolean checkZero(String str) {
        return checkNull(str) || checkEmpty(str);
    }

    private static String[] splitStr(String str) {
        return str.split(delimiter);
    }

    private static int parseStr(String str) {
        return Integer.parseInt(str);
    }

    private static boolean checkSingle(String str) {
        return splitStr(str).length < 1;
    }

    public static int splitAndSum(String str) {
        if (checkZero(str)) {
            return 0;
        }
        if (checkSingle(str)) {
            return parseStr(str);
        }
        return 1;
    }
}
