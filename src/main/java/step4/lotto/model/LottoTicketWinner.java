package step4.lotto.model;

public class LottoTicketWinner {

    private final LottoTicket lastWeekWinningTicket;
    private final LottoNumber bonusLottoNumber;

    public LottoTicketWinner(LottoTicket lastWeekWinningTicket, LottoNumber bonusLottoNumber) {
        this.lastWeekWinningTicket = lastWeekWinningTicket;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        LottoMatchCount lottoMatchCount = lottoTicket.matchLottoNumbers(lastWeekWinningTicket);
        LottoMatchBonusCount lottoMatchBonusCount = lottoTicket.matchBonusLottoNumber(bonusLottoNumber);
        return LottoPrize.of(lottoMatchCount, lottoMatchBonusCount);
    }

}
