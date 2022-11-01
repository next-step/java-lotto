package lotto.domain;

public class WinningLotto {

    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(final LottoTicket winningNumbers, final LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(final LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.countSameNumber(this.winningNumbers), lottoTicket.contains(this.bonusNumber));
    }
}
