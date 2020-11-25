package lotto.domain;

public class Calculator {

    final static int PRICE = 1000;

    private final int lottoTicketPrice;

    public Calculator() {
        this.lottoTicketPrice = PRICE;
    }

    public int calculateLottoTicket(int input) {
        validate(input);
        return input/lottoTicketPrice;
    }

    private void validate(int input) {
        if (Integer.compare(input, lottoTicketPrice) == -1)
            throw new IllegalArgumentException();
    }
}
