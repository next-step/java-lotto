package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        validate(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto lotto, LottoNumber bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨된 6개의 로또번호에 포함될 수 없습니다.");
        }
    }

    public WinningStatistics getWinningStatistics(LottoTickets purchasedLottoTickets) {
        WinningStatistics statistics = new WinningStatistics(purchasedLottoTickets.size());
        for (Lotto purchasedLotto : purchasedLottoTickets.getTickets()) {
            long matchedWinningCount = purchasedLotto.countToMatchedWinningNumbers(this.lotto);
            boolean isMatchedBonusBall = purchasedLotto.contains(bonusBall);
            statistics.addMatchedCount(toLottoRank(matchedWinningCount, isMatchedBonusBall));
        }
        return statistics;
    }

    public LottoRank toLottoRank(long matchedCount, boolean isMatchedBonusBall) {
        return LottoRank.findLottoRank(matchedCount, isMatchedBonusBall);
    }

}