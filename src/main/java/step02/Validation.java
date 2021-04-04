package step02;

import static step02.LottoConfig.*;

public class Validation {

    private Validation() {}

    public static void overMaxNumber(int number) throws Exception {
        if (number > NUMBER_RANGE_END) {
            throw new Exception(ERROR_OVER_MAX_NUMBER);
        }
    }

    public static void overMaxNumberCount(int size) throws Exception {
        if (size > LOTTO_NUMBER_MAX_COUNT) {
            throw new Exception(ERROR_OVER_MAX_NUMBER_COUNT);
        }
    }
}
