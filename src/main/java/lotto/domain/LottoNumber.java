package lotto.domain;

public class LottoNumber extends AbstractLottoNumber {

    public LottoNumber(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
