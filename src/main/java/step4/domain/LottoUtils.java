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

    public static int[][] parseManualLottoNosLines(String[] parseSplitManualLottoNosLines) {
        return Arrays.stream(parseSplitManualLottoNosLines)
                .map(parseSplitManualLottoNosLine -> parseSplitManualLottoNosLine.split(DELIMITER))
                .map(LottoUtils::convert)
                .toArray(int[][]::new);
    }

    private static int[] convert(String[] tmp) {
        return Arrays.stream(tmp)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
