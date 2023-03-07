package lotto.domain;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public LottoTickets buyLotto(int price) {
        int ticketCount = calLottoTicketCount(price);
        return LottoTickets.of(ticketCount);
    }

    protected int calLottoTicketCount(int price) {
        checkPrice(price);
        return price / LOTTO_PRICE;
    }

    private void checkPrice(int price) {
        if (price < LOTTO_PRICE) {
            String message = String.format("로또 가격은 %d원 입니다. 잔액이 부족 합니다. price: %d", LOTTO_PRICE, price);
            throw new IllegalArgumentException(message);
        }
    }
}
