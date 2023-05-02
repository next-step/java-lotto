package lotto.domain;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;

    public WinningLotto(LottoTicket winningLottoTicket) {
        this.winningLottoTicket = winningLottoTicket;
    }

    public WinningRank match(LottoTicket lottoTicket) {
        int matchCount = countOfMatch(lottoTicket);
        return WinningRank.valueOf(matchCount);
    }

    public int countOfMatch(LottoTicket lottoTicket) {
        return lottoTicket.countMatchingNumbersWithWinningTicket(winningLottoTicket);
    }

    public LottoTicket findWinningLotto() {
        return winningLottoTicket;
    }
}



