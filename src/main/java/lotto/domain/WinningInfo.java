package lotto.domain;

public class WinningInfo {

    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    public WinningInfo(WinningNumber winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public long matchWinning(Ticket ticket) {
        return ticket.matchWinningNumber(winningNumber);
    }

    public boolean matchBonus(Ticket ticket) {
        return ticket.matchBonus(bonusNumber);
    }
}
