package stringcalulator.model;

public class Constant {
    public static class Exception {
        public static String DOES_NOT_NUMBER_AND_SYMBOL = "숫자와 연산자만 입력할 수 있습니다.";
        public static String DOES_NOT_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
        public static String NOT_EXIST_OPERATOR = "해당 연산자가 존재하지 않습니다.";
    }

    public static class regexPattern {
        public static String REGEX_OPERATOR = "[+\\-*/]";
        public static String REGEX_INPUT_VALIDATION = "^[+\\-*/\\d\\s]*$";
    }
}
