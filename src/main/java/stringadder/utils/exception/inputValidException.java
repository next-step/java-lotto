package stringadder.utils.exception;

public class inputValidException {

    private static final String NEGATIVE_INPUT_ERROR = "음수는 입력할 수 없습니다!";
    private static final String NOT_NUMBER_ERROR = "구분자를 포함한 숫자 이외의 값은 입력하면 안됩니다.";

    public static void inputNegativeValidation(String input) {
        if(Integer.valueOf(input)<0)
            throw new RuntimeException(NEGATIVE_INPUT_ERROR);
    }

    public static int inputNotNumberValidation(String input){
        if(Character.isDigit(input.charAt(0))){
            return Integer.valueOf(input);
        }
        throw new RuntimeException(NOT_NUMBER_ERROR);
    }

    public static int emptyOrNullValidation(String input){
        if(input.isEmpty() || input == null)
            return 0;
        return Integer.valueOf(input);
    }
}
