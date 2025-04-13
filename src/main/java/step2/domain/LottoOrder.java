package step2.domain;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    private final int price;
    private final LottoList lottoList;

    public LottoOrder(int price) {
        this.price = price;
        int count = price / Lotto.getLottoPrice();
        this.lottoList = new LottoList(count);
    }

    public int getQuantity() {
        return lottoList.size();
    }
}
