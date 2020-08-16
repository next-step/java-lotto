package nextstep.lotto.utils;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_ONLY_NUMBER;
import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_ONLY_POSITIVE_NUMBER;

public class IntegerUtils {

    private IntegerUtils() {
    }

    public static int parsePositiveInt(String inputStringValue) {
        int parseInt = 0;
        try {
            parseInt = Integer.parseInt(inputStringValue);
        } catch(NumberFormatException e) {
            throw new RuntimeException(INVALID_INPUT_ONLY_NUMBER);
        }

        if(parseInt < 0){
            throw new RuntimeException(INVALID_INPUT_ONLY_POSITIVE_NUMBER);
        }

        return parseInt;
    }
}
