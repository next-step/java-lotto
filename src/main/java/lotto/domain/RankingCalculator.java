package lotto.domain;

public class RankingCalculator {
    public LottoResult calculate(WinningNumbers winningNumbers, LottoTickets lottoTickets, int expect) {
        int hits = 0;
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = checkLottoMatchCount(winningNumbers, lottoTicket);
            hits = increaseResultIfMatchCountSameWithExpect(expect, matchCount, hits);
        }
        return new LottoResult(expect, hits);
    }

    private int checkLottoMatchCount(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            matchCount = increaseIfLastWeekWinningContainsElement(winningNumbers, lottoNumber, matchCount);
        }
        return matchCount;
    }

    private int increaseIfLastWeekWinningContainsElement(WinningNumbers winningNumbers,
                                                         LottoNumber element, int matchCount) {
        if (winningNumbers.contains(element)) {
            return matchCount + 1;
        }
        return matchCount;
    }

    private int increaseResultIfMatchCountSameWithExpect(int expect, int matchCount, int result) {
        if (matchCount == expect) {
            return result + 1;
        }
        return result;
    }
}
