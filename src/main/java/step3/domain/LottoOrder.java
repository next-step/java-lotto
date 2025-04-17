package step3.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    private final Integer price;
    private final Lottos lottos;

    public LottoOrder(int totalPrice) {
        int count = totalPrice / Lotto.getLottoPrice();
        this.price = count * Lotto.getLottoPrice();
        this.lottos = new Lottos(count);
    }

    public Lottos lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public int price() {
        return price;
    }
}
