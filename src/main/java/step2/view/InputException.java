package step2.view;

public class InputException {


    public static boolean inputAlpha(String input) {
        if (isAlpha(input)) {
            System.out.println("숫자값만 입력해주세요.");
            return true;
        }
        return false;
    }

    private static boolean isAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
