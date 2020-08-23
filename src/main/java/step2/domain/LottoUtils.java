package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {

    private static final String DELIMITER = ", ";

    private LottoUtils() {

    }

    public static int[] splitWinningNumberLineAndReturnLottoNumbers(String winningNumberLine) {
        return Arrays.stream(winningNumberLine.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<Integer> collectWinningNumberCount(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.findWinningNumbersCount(winningNumbers))
                .collect(Collectors.toList());
    }

}
