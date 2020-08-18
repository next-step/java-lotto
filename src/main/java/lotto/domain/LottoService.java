package lotto.domain;

public class LottoService {

    private static final int LOTTO_TICKET_PRICE = 1000;
    public static final String PRINT_INVALID_LOTTO_PRICE = "로또 복권은 1000원 단위로 구매할 수 있습니다.";

    public int buyLottoTicket(int price) {
        invalidLottoTicketInputPrice(price);
        return price / LOTTO_TICKET_PRICE;
    }

    public void invalidLottoTicketInputPrice(int price) {
        if ((price % LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException(PRINT_INVALID_LOTTO_PRICE);
        }
    }

}
