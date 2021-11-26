package lotto.domain;

import lotto.domain.value.OrderCount;
import lotto.domain.value.OrderPrice;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    private final OrderPrice lottoPrice;
    private final OrderCount lottoCount;

    private Store(String orderPrice) {

        checkOrderPrice(orderPrice);

        this.lottoPrice = OrderPrice.from(Integer.parseInt(orderPrice));
        this.lottoCount = OrderCount.from(this.lottoPrice.getLottoPrice() / LOTTO_PRICE);
    }


    public static Store of(String orderPrice) {
        return new Store(orderPrice);
    }

    public int getLottoCount() {
        return lottoCount.getLottoCount();
    }

    public LottoTicket purchaseTicket() {

        return new LottoTicket(lottoCount.getLottoCount());
    }

    private void checkOrderPrice(String orderPrice) {

        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다!!!!");
            }
        }
    }

    public OrderPrice getLottoPrice() {
        return lottoPrice;
    }
}
