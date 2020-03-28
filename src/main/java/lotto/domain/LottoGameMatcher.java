package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameMatcher {
    private static final int WINNING_MIN_LIMIT = 3;

    private LottoGameMatcher() {
    }

    public static LottoGameResults matchWinningNumber(LottoTickets boughtTickets, LottoNumber winningNumber) {
        List<LottoRank> lottoRanks = boughtTickets.checkRank(winningNumber);
        return new LottoGameResults(
                lottoRanks.size(),
                filterWinningGame(lottoRanks)
        );
    }

    private static List<LottoRank> filterWinningGame(List<LottoRank> winnings) {
        return winnings.stream()
                .filter(LottoGameMatcher::isGraterThanThree)
                .collect(Collectors.toList());
    }

    private static boolean isGraterThanThree(LottoRank lottoRank) {
        return lottoRank.getWinningPrize() >= WINNING_MIN_LIMIT;
    }

}
