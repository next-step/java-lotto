package step2step3.lotto.lottoTicket;

public class WinningLottoInformation {
    private final int bonusNumber;
    private final LottoTicket winningLottoTicket;

    public WinningLottoInformation(int bonusNumber, LottoTicket winningLottoTicket) {
        this.bonusNumber = bonusNumber;
        this.winningLottoTicket = winningLottoTicket;
    }

    public Rank matchedRank(LottoTicket lottoTicket) {
        Rank rank = winningLottoTicket.rank(lottoTicket);

        return isSecond(lottoTicket, rank)
                ? Rank.SECOND
                : rank;
    }

    private boolean isSecond(LottoTicket lottoTicket, Rank rank) {
        return lottoTicket.hasBonusNumber(bonusNumber) && rank == Rank.THIRD;
    }
}
