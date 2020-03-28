package lotto.domain;

public class LottoGameMatcher {
    private static final int WINNING_MIN_LIMIT = 3;

    private LottoGameMatcher() {
    }

    public static LottoGameResults matchWinningNumber(LottoTickets boughtTickets, LottoNumber winningNumber) {
        return new LottoGameResults(boughtTickets.checkRank(winningNumber));
    }

}
