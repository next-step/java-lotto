package lotto.domain;

import lotto.domain.value.OrderCount;
import lotto.domain.value.OrderPrice;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    private final OrderPrice orderPrice;
    private final OrderCount orderCount;

    private Store(String orderPrice) {

        checkOrderPrice(orderPrice);

        this.orderPrice = OrderPrice.from(Integer.parseInt(orderPrice));
        this.orderCount = OrderCount.from(this.orderPrice.getOrderPrice() / LOTTO_PRICE);
    }


    public static Store of(String orderPrice) {
        return new Store(orderPrice);
    }

    public int getOrderCount() {
        return orderCount.getOrderCount();
    }

    public LottoTicket purchaseTicket() {

        return new LottoTicket(orderCount.getOrderCount());
    }

    private void checkOrderPrice(String orderPrice) {

        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다!!!!");
            }
        }

        if (Integer.parseInt(orderPrice) < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 살수 있는 최소 금액은 1000원 입니다!!");
        }
    }

}
