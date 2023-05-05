package lotto.domain;

public class WinnerTicket {
    private final Ticket ticket;
    private final LottoNumber bonusNumber;

    public WinnerTicket(Ticket ticket, LottoNumber bonusNumber) {
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public Ticket ticket() {
        return this.ticket;
    }

    public Boolean includeBonus(Ticket ticket) {
        return ticket.includeNumber(this.bonusNumber);
    }

    public Prize checkLucky(Ticket thatTicket) {
        int matchCount = this.ticket.countMatchNumbers(thatTicket);
        boolean containsBonus = thatTicket.includeNumber(bonusNumber);
        return Prize.calculatePrize(matchCount, containsBonus);
    }
}
