package step4.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    private final Amount price;
    private final Lottos lottos;

    public LottoOrder(int totalPrice) {
        this.price = new Amount(totalPrice);
        this.lottos = Lottos.createLottosByPrice(this.price);
    }

    public Lottos lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Amount price() {
        return price;
    }
}
