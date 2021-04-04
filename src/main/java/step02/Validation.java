package step02;

import static step02.LottoConfig.*;

public class Validation {

    private Validation() {}

    public static void overMaxNumber(int number) throws Exception {
        if (number > NUMBER_RANGE_END) {
            throw new Exception(ERROR_OVER_MAX_NUMBER);
        }
    }
}
