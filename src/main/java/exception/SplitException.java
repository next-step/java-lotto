package exception;

public class SplitException {

    public static String[] split(String input) {
        String[] splitArr = input.split(" ");
        checkSplitArr(splitArr);
        for (String str : splitArr) {
            checkEmpty(str);
        }
        return splitArr;
    }

    public static void checkSplitArr(String[] splitArr) {
        if (splitArr.length < 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkEmpty(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
