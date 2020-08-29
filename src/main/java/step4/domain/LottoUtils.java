package step4.domain;

import java.util.Arrays;

public class LottoUtils {

    private static final String DELIMITER = ", ";

    private LottoUtils() {

    }

    public static int[] splitWinningNumberLineAndReturnLottoNumbers(String winningNumberLine) {
        return Arrays.stream(winningNumberLine.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
