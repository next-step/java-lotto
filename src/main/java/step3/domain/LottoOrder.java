package step3.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    private final Amount price;
    private final Lottos lottos;

    public LottoOrder(int totalPrice) {
        this.price = new Amount(totalPrice);
        this.lottos = new Lottos(convertToCount(totalPrice));
    }

    public Lottos lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public int price() {
        return price.getAmount();
    }

    private int convertToCount(int totalPrice) {
        return totalPrice / Lotto.getLottoPrice();
    }
}
