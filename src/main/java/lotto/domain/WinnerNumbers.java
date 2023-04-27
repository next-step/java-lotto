package lotto.domain;

public class WinnerNumbers {

    private final LottoNumbers winnerLottoNumbers;
    private final LottoNumber bonusBall;

    public WinnerNumbers(LottoNumbers winnerLottoNumbers, LottoNumber bonusBall) {
        validate(winnerLottoNumbers, bonusBall);
        this.winnerLottoNumbers = winnerLottoNumbers;
        this.bonusBall = bonusBall;
    }

    private void validate(LottoNumbers winnerNumbers, LottoNumber bonusBall) {
        if (winnerNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨된 6개의 로또번호에 포함될 수 없습니다.");
        }
    }

    public WinnerStatistics getWinnerStatistics(LottoTickets purchasedLottoTickets) {
        WinnerStatistics statistics = new WinnerStatistics(purchasedLottoTickets.size());
        for (LottoNumbers lottoNumbers : purchasedLottoTickets.getTickets()) {
            long matchedWinnerCount = lottoNumbers.countToMatchedWinnerNumbers(winnerLottoNumbers);
            boolean isMatchedBonusBall = lottoNumbers.contains(bonusBall);
            statistics.addMatchedCount(toLottoRank(matchedWinnerCount, isMatchedBonusBall));
        }
        return statistics;
    }

    public LottoRank toLottoRank(long matchedCount, boolean isMatchedBonusBall) {
        return LottoRank.findLottoRank(matchedCount, isMatchedBonusBall);
    }

}