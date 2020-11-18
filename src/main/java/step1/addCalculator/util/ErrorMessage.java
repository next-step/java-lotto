package step1.addCalculator.util;

public class ErrorMessage {
    private static String NEGATIVEEXCEPTION = "음수를 입력하였습니다.";
    private static String NUMBERFORMATEXCEPTION = "문자를 입력하였습니다. 숫자를 입력해주세요";


    private ErrorMessage() {

    }

    public static String getNEGATIVEEXCEPTION() {
        return NEGATIVEEXCEPTION;
    }

    public static String getNUMBERFORMATEXCEPTION() {
        return NUMBERFORMATEXCEPTION;
    }
}


