package calculator;

public class StringCalculator {
    private static final int EMPTY_NUM = 0;
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_OR_COLON_DELIMITER = ",|:";

    int result;

    int add(String val) {

        if (isNull(val)) {
            return EMPTY_NUM;
        }
        if (isEmpty(val)) {
            return EMPTY_NUM;
        }
        String[] numStrings = stringToNumStrings(val, COMMA_OR_COLON_DELIMITER);
        for (String numStr : numStrings) {
            int num = stringToNum(numStr);
            result += num;
        }

        return result;
    }

    String[] stringToNumStrings(String val, String delimiter) {
        return val.split(delimiter);
    }

    int stringToNum(String val) {
        return Integer.parseInt(val);
    }

    boolean isNull(String value) {
        if (value == null) {
            return true;
        }
        return false;
    }

    boolean isEmpty(String value) {
        value = value.trim();
        if (value.isEmpty()) {
            return true;
        }
        return false;
    }
}
