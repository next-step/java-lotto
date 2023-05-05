package lotto.domain;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;

    public WinningLotto(LottoTicket winningLottoTicket) {
        this.winningLottoTicket = winningLottoTicket;
    }

    public WinningRank match(LottoTicket lottoTicket) {
        return match(lottoTicket, null);
    }

    public WinningRank match(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        int matchCount = countOfMatch(lottoTicket);
        boolean isBonusNumberMatching  = bonusNumber != null && lottoTicket.matchesBonusNumber(bonusNumber);
        return WinningRank.valueOf(matchCount, isBonusNumberMatching );
    }

    public int countOfMatch(LottoTicket lottoTicket) {
        return lottoTicket.countMatchingNumbersWithWinningTicket(winningLottoTicket);
    }

    public LottoTicket findWinningLotto() {
        return winningLottoTicket;
    }
}



