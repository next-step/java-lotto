package lotto.domain;

import lotto.domain.value.OrderCount;
import lotto.domain.value.OrderPrice;

public class Store {

    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_CHECK_ERROR_MSG = "숫자만 입력 가능합니다!!!!";

    private final OrderPrice lottoPrice;
    private final OrderCount lottoCount;

    public Store(String orderPrice) {

        checkOrderPrice(orderPrice);

        this.lottoPrice = new OrderPrice(Integer.parseInt(orderPrice));
        this.lottoCount = new OrderCount(this.lottoPrice.getLottoPrice() / LOTTO_PRICE);
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
                throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
            }
        }
    }

    public OrderPrice getLottoPrice() {
        return lottoPrice;
    }
}
