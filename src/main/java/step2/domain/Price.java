package step2.domain;

import static step2.domain.LottoTicket.LOTTO_PRICE;

public class Price {
    private int price;

    public Price(int inputPrice) {
        this.price = inputPrice;
        checkPrice(price);
    }

    private void checkPrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다");
        }
    }

    public int countLotto() {
        return price / LOTTO_PRICE;
    }
}
