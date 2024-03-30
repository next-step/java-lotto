package lotto.domain;

public class WinningTicket {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinnerPrize rank(LottoTicket lottoTicket) {
        return WinnerPrize.valueOf(lottoTicket.getMatchCount(winningNumbers),
                lottoTicket.contains(bonusNumber));
    }
}
