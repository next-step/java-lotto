package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameMatcher {
    private LottoGameMatcher() {
    }

    public static LottoGameResults matchToMap(LottoNumbers boughtNumbers, LottoNumber winningNumber) {
        List<Long> winnings = boughtNumbers.getCheckedNumbers(winningNumber);
        return new LottoGameResults(
                winnings.size(),
                filterWinningGame(winnings)
        );
    }

    private static List<Long> filterWinningGame(List<Long> winnings) {
        return winnings.stream()
                .filter(LottoGameMatcher::isGraterThanThree)
                .collect(Collectors.toList());
    }

    private static boolean isGraterThanThree(long matchCount) {
        return matchCount >= 3;
    }

}
