package step2step3.lotto;

public class RankJudgmentInformation {
    private final int bonusNumber;
    private final LottoTicket winningLottoTicket;

    public RankJudgmentInformation(int bonusNumber, LottoTicket winningLottoTicket) {
        this.bonusNumber = bonusNumber;
        this.winningLottoTicket = winningLottoTicket;
    }

    public boolean isSecond(LottoTicket lottoTicket) {
        if (!lottoTicket.hasBonusNumber(bonusNumber)) {
            return false;
        }

        return lottoTicket.rank(winningLottoTicket) == Rank.THIRD;
    }

    public LottoTicket winningLottoTicket() {
        return winningLottoTicket;
    }
}
