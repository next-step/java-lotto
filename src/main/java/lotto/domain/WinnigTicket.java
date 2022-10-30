package lotto.domain;

public class WinnigTicket {
    private final Ticket ticket;

    private final LottoNumber bonusNumber;

    public WinnigTicket(Ticket ticket, int bonusNumber) {
        this(ticket, new LottoNumber(bonusNumber));
    }

    public WinnigTicket(Ticket ticket, LottoNumber bonusNumber) {
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
