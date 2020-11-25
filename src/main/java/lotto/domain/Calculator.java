package lotto.domain;

public class Calculator {

    final static int PRICE = 1000;

    private final int lottoTicketPrice;

    public Calculator() {
        this.lottoTicketPrice = PRICE;
    }

    public int calculateLottoTicket(int input) {
        return input/lottoTicketPrice;
    }
}
