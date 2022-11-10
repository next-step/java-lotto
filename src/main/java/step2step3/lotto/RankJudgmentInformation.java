package step2step3.lotto;

public class RankJudgmentInformation {
    private final int bonusNumber;
    private final LottoTicket winningLottoTicket;

    public RankJudgmentInformation(int bonusNumber, LottoTicket winningLottoTicket) {
        this.bonusNumber = bonusNumber;
        this.winningLottoTicket = winningLottoTicket;
    }

    public LottoTicket winningLottoTicket() {
        return winningLottoTicket;
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
