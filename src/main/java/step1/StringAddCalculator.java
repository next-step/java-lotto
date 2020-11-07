package step1;

public class StringAddCalculator {

    private static boolean checkNull(String str) {
        return str == null;
    }

    private static boolean checkEmpty(String str) {
        return str.isEmpty();
    }

    private static boolean checkZero(String str) {
        return checkNull(str) || checkEmpty(str);
    }

    public static int splitAndSum(String str) {
        if (checkZero(str)) {
            return 0;
        }
        return 1;
    }
}
