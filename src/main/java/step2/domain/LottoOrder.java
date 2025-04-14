package step2.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    // 로또 구매 단가 - 실제 로또 가격은 LottoList에서
    private final int totalPrice;
    private final LottoList lottoList;

    public LottoOrder(int totalPrice) {
        this.totalPrice = totalPrice;
        int count = totalPrice / Lotto.getLottoPrice();
        this.lottoList = new LottoList(count);
    }

    public LottoList getLottoList() {
        return lottoList;
    }
}
