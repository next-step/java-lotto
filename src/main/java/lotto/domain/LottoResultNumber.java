package lotto.domain;

public class LottoResultNumber extends AbstractLottoNumber {

    public LottoResultNumber(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String toString() {
        return ticket.toString().substring(1, ticket.toString().length() - 1);
    }
}
