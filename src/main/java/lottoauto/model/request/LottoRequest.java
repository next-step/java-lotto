package lottoauto.model.request;

public class LottoRequest {

     private static final int ONE_LOTTO_PRICE = 1000;

    private final int buyLottoPrice;

    public LottoRequest(int buyLottoPrice) {
        priceValidation(buyLottoPrice);
        this.buyLottoPrice = buyLottoPrice;
    }

    private void priceValidation(int buyLottoPrice) {

        if (buyLottoPrice < 0) {
            throw new IllegalArgumentException("0보다 큰 금액을 입력하셔야 합니다.");
        }

        if (buyLottoPrice < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한개의 금액은 1000원 입니다.");
        }

    }

    public int getLottoQuantity() {
        return buyLottoPrice / ONE_LOTTO_PRICE;
    }
}
