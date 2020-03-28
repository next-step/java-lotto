package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameMatcher {
    private static final int WINNING_MIN_LIMIT = 3;

    private LottoGameMatcher() {
    }

    public static LottoGameResults matchWinningNumber(LottoNumbers boughtNumbers, LottoNumber winningNumber) {
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
        return matchCount >= WINNING_MIN_LIMIT;
    }

}
