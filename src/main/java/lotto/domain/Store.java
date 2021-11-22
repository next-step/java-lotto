package lotto.domain;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    private static int orderPrice;
    private static int orderCount;
    private static LottoTicket lottoTicket;

    private Store(String orderPrice) {

        checkOrderPrice(orderPrice);

        this.orderPrice = Integer.parseInt(orderPrice);
        this.orderCount = this.orderPrice / LOTTO_PRICE;
        lottoTicket = new LottoTicket(orderCount);
    }


    public static Store of(String orderPrice) {
        return new Store(orderPrice);
    }

    public static LottoTicket getLottoTicket() {
        return lottoTicket;
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

    public static int getOrderCount() {
        return orderCount;
    }
}
