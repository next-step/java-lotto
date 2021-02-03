package lotto.domain;

public class WinningNumber {

    private final Ticket winningNumber;
    private final Integer bonusNumber;

    public WinningNumber(Ticket winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public long checkTicketAndWinning(Ticket ticket) {
        return winningNumber.matchNumber(ticket);
    }

    public boolean checkTicketAndBonus(Ticket ticket) {
        return ticket.lottoNumberStream().anyMatch(ticketObject -> ticketObject.equals(bonusNumber));
    }
}
