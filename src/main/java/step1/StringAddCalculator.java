package step1;

public class StringAddCalculator {

    private static final String defaultRegex = "\\,|\\:";

    private static boolean checkNull(String str) {
        return str == null;
    }

    private static boolean checkEmpty(String str) {
        return str.isEmpty();
    }

    private static boolean checkZero(String str) {
        return checkNull(str) || checkEmpty(str);
    }

    private static String[] splitStr(String str, String regex) {
        return str.split(regex);
    }

    private static void validateNum(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }

    private static int parseStr(String str) {
        int num = Integer.parseInt(str);
        validateNum(num);
        return Integer.parseInt(str);
    }

    private static boolean checkSingle(String str, String regex) {
        return splitStr(str, regex).length < 1;
    }

    private static int[] parseStrArr(String[] strArr) {
        int length = strArr.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = parseStr(strArr[i]);
        }
        return arr;
    }

    private static int calcSum(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        return sum;
    }

    private static int calcSum(String str, String regex) {
        String[] strArr = splitStr(str, regex);
        int[] intArr = parseStrArr(strArr);
        return calcSum(intArr);
    }

    public static int splitAndSum(String str) {
        if (checkZero(str)) {
            return 0;
        }
        if (checkSingle(str, defaultRegex)) {
            return parseStr(str);
        }
        return calcSum(str, defaultRegex);
    }
}
