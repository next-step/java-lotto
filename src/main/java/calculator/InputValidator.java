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

//    public static boolean checkInvalidInput(String text) throws RuntimeException {
//        try {
//            int input= Integer.parseInt(text);
//            if(input < 0) {
//                throw new RuntimeException("음수는 연산이 불가합니다.");
//            }
//            return true;
//        } catch (Exception e) {
//            throw new RuntimeException("올바른 수를 입력해주세요.");
//        } finally {
//
//        }
//    }
    public static boolean checkInvalidInput(String text) {
        try {
            return isNegative(text) && isLetter(text);
        } catch (Exception e) {
            System.out.println("올바른 양의 정수를 입력해주세요.");
            return false;
        }
    }

    public static boolean isNegative (String text) throws RuntimeException {
        int input= Integer.parseInt(text);
        if(input < 0) {
            throw new RuntimeException();
        }
        return true;
    }

    public static boolean isLetter (String text) throws RuntimeException {
        try {
            int input = Integer.parseInt(text);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return true;
    }
}
