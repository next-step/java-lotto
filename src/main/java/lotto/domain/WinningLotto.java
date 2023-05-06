package lotto.domain;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;
    private final BonusNumber bonusNumber;

    public WinningLotto(LottoTicket winningLottoTicket, Integer bonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = createBonusNumber(bonusNumber);
    }

    private BonusNumber createBonusNumber(Integer bonusNumber) {
        if (bonusNumber == null) {
            return null;
        }
        return new BonusNumber(bonusNumber);
    }

    public WinningRank match(LottoTicket lottoTicket) {
        int matchCount = countMatchingNumbers(lottoTicket);
        boolean isBonusNumberMatching  = bonusNumber != null && lottoTicket.matchesBonusNumber(bonusNumber);
        return WinningRank.valueOf(matchCount, isBonusNumberMatching);
    }

    public int countMatchingNumbers(LottoTicket lottoTicket) {
        return lottoTicket.countMatchingNumbersWithWinningTicket(winningLottoTicket);
    }

    public LottoTicket findWinningLotto() {
        return winningLottoTicket;
    }
}



