package calculator;

public class InputValidator {

    public static boolean checkIsNullOrIsEmpty(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.trim().isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }

    public static boolean checkMinusParamInput(String text) throws RuntimeException {
        if(Integer.parseInt(text) < 0) {
            throw new RuntimeException("음수는 연산이 불가합니다.");
        }
        return true;
    }

    public static boolean isNumber(String text)  {
        try {
            Integer.parseInt(text);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
