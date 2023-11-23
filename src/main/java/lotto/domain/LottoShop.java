package lotto.domain;

// 개선 필요
public class LottoShop {
    private static final Integer LOTTO_TICKET_PRICE = 1000;

    public int sellTicket(int totalPrice) {
        return totalPrice / LOTTO_TICKET_PRICE;
    }
}
