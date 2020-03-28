package lotto.domain;

public class LottoGameMatcher {

    private LottoGameMatcher() {
    }

    public static LottoGameResults matchWinningNumber(LottoTickets boughtTickets, WinningNumber winningNumber) {
        return new LottoGameResults(boughtTickets.checkRank(winningNumber));
    }

}
