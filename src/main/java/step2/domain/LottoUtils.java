package step2.domain;

import java.util.Arrays;

public class LottoUtils {

    public static final String DELIMITER = ", ";

    private LottoUtils() {

    }

    public static int[] splitWinningNumberLineAndReturnLottoNumbers(String winningNumberLine) {
        return Arrays.asList(winningNumberLine.split(DELIMITER)).stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
