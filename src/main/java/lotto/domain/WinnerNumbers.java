package lotto.domain;

public class WinnerNumbers {

    private final Lotto winnerLotto;
    private final LottoNumber bonusBall;

    public WinnerNumbers(Lotto winnerLotto, LottoNumber bonusBall) {
        validate(winnerLotto, bonusBall);
        this.winnerLotto = winnerLotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto winnerNumbers, LottoNumber bonusBall) {
        if (winnerNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨된 6개의 로또번호에 포함될 수 없습니다.");
        }
    }

    public WinnerStatistics getWinnerStatistics(LottoTickets purchasedLottoTickets) {
        WinnerStatistics statistics = new WinnerStatistics(purchasedLottoTickets.size());
        for (Lotto lotto : purchasedLottoTickets.getTickets()) {
            long matchedWinnerCount = lotto.countToMatchedWinnerNumbers(winnerLotto);
            boolean isMatchedBonusBall = lotto.contains(bonusBall);
            statistics.addMatchedCount(toLottoRank(matchedWinnerCount, isMatchedBonusBall));
        }
        return statistics;
    }

    public LottoRank toLottoRank(long matchedCount, boolean isMatchedBonusBall) {
        return LottoRank.findLottoRank(matchedCount, isMatchedBonusBall);
    }

}