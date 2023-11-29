package lotto.domain;

// 개선 필요
public class LottoShop {
    private static final Integer LOTTO_TICKET_PRICE = 1000;

    public int sellTicket(int totalPrice) {
        validTicket(totalPrice);
        return totalPrice / LOTTO_TICKET_PRICE;
    }

    private void validTicket(int totalPrice) {
        if (totalPrice < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("로또는 최소 한장이상 구매할 수 있습니다.");
        }
    }
}
