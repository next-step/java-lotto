package step3.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    // 로또 구매 단가 - 실제 로또 가격은 LottoList에서
    private final Integer totalPrice;
    private final Lottos lottos;

    public LottoOrder(int totalPrice) {
        this.totalPrice = totalPrice;
        int count = totalPrice / Lotto.getLottoPrice();
        this.lottos = new Lottos(count);
    }

    public Lottos lottos() {
        return lottos;
    }
}
