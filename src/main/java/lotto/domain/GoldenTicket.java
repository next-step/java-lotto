package lotto.domain;

/**
 * 당첨번호 (보너스볼 포함)
 */
public class GoldenTicket {

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public GoldenTicket(final LottoTicket winningTicket, final LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchedNumbersCount(final LottoTicket lottoTicket) {
        return this.winningTicket.getSameNumbersCount(lottoTicket);
    }

    public boolean containsBonusBall(final LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
