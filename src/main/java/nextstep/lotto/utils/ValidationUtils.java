package nextstep.lotto.utils;

public class ValidationUtils {

    private static final String EMPTY_STRING = "";

    private ValidationUtils() {
    }

    public static boolean isNullAndEmpty(String inputValue){
        if(inputValue == null){
            return true;
        }

        if(inputValue.trim().equals(EMPTY_STRING)) {
            return true;
        }
        return false;
    }

}
