package lotto;

public class Buyer {
    private LottoPrice lottoPrice = new LottoPrice();

    public int buyLotto(int purchase) {
        return purchase / lottoPrice.getLottoPrice();
    }
}
