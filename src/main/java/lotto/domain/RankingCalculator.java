package lotto.domain;

public class RankingCalculator {
    public LottoResult calculate(WinningNumbers winningNumbers, LottoTickets lottoTickets, Ranking ranking) {
        int hits = 0;
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            MatchResult matchResult = checkLottoMatchCount(winningNumbers, lottoTicket);
            hits = increaseHitsIfEqualToRanking(ranking, matchResult, hits);
        }
        return new LottoResult(ranking, hits);
    }

    private MatchResult checkLottoMatchCount(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        int lottoNumberMatches = 0;
        boolean hasBonusNumber = false;
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            lottoNumberMatches = increaseIfWinningNumbersContainsLottoNumber(winningNumbers, lottoNumber, lottoNumberMatches);
            hasBonusNumber = checkBonusNumber(winningNumbers, lottoNumber);
        }
        return new MatchResult(lottoNumberMatches, hasBonusNumber);
    }

    private int increaseIfWinningNumbersContainsLottoNumber(WinningNumbers winningNumbers,
                                                            LottoNumber element, int matchCount) {
        if (winningNumbers.contains(element)) {
            return matchCount + 1;
        }
        return matchCount;
    }

    private boolean checkBonusNumber(WinningNumbers winningNumbers, LottoNumber lottoNumber) {
        return winningNumbers.containsBonusNumber(lottoNumber);
    }

    private int increaseHitsIfEqualToRanking(Ranking ranking, MatchResult matchResult, int hits) {

        int matchCount = matchResult.getMatchCount();
        boolean hasBonusNumber = matchResult.hasBonusNumber();

        if(ranking.isEqualTo(matchCount, hasBonusNumber)) {
            return hits + 1;
        }

        return hits;
    }

    private static class MatchResult {
        private final int matchCount;
        private final boolean hasBonusNumber;

        public MatchResult(int matchCount, boolean hasBonusNumber) {
            this.matchCount = matchCount;
            this.hasBonusNumber = hasBonusNumber;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public boolean hasBonusNumber() {
            return hasBonusNumber;
        }
    }
}
