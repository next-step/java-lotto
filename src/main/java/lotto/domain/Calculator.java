package lotto.domain;

public class Calculator {

    final static int LOTTO_TICKET_PRICE = 1000;

    public int calculateLottoTicket(int input) {
        validate(input);
        return input/ LOTTO_TICKET_PRICE;
    }

    private void validate(int input) {
        if (Integer.compare(input, LOTTO_TICKET_PRICE) == -1)
            throw new IllegalArgumentException();
    }
}
