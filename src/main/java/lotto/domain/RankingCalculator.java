package lotto.domain;

import java.util.List;

public class RankingCalculator {
    public LottoResult calculate(List<LottoNumber> lastWeekWinning, LottoTickets lottoTickets, int expect) {
        int hits = 0;
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = checkLottoMatchCount(lastWeekWinning, lottoTicket);
            hits = increaseResultIfMatchCountSameWithExpect(expect, matchCount, hits);
        }
        return new LottoResult(expect, hits);
    }

    private int checkLottoMatchCount(List<LottoNumber> lastWeekWinning, LottoTicket lottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            matchCount = increaseIfLastWeekWinningContainsElement(lastWeekWinning, lottoNumber, matchCount);
        }
        return matchCount;
    }

    private int increaseIfLastWeekWinningContainsElement(List<LottoNumber> lastWeekWinningElements,
                                                         LottoNumber element, int matchCount) {
        if (lastWeekWinningElements.contains(element)) {
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
