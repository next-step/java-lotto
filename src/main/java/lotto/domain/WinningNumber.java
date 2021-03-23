package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final static String DEFAULT_REGEX = ",";

    public WinningNumber(String winningNumber) {
        String[] test = winningNumber.split(DEFAULT_REGEX);
        winningNumbers = Arrays.stream(test)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Hit getWinnerStatistics(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        Hit hit = new Hit();
        for (Lotto lotto : lottoList) {
            int matchCount = (int) getMatchCount(lotto);
            hit.hittingLottoStatistics(matchCount);
        }
        return hit;
    }

    private long getMatchCount(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
