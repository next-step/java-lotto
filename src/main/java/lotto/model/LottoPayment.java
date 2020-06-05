package lotto.model;

public class LottoPayment {

    private final int LOTTO_PRICE = 1000;
    private String inputPrice;

    public LottoPayment(String inputPrice) {
        this.inputPrice = inputPrice;
    }

    public int pay() {
        return getLottoCount(this.inputPrice);
    }

    private int getLottoCount(String price){
        if(validate(price)) {
            throw new IllegalArgumentException("금액을 입력해 주세요.");
        }
        int lottoPrice = Integer.parseInt(price);
        if(lottoPrice < LOTTO_PRICE) {
            return 0;
        }
        return lottoPrice / LOTTO_PRICE;
    }

    private boolean validate(String price){
        return price == null || price.isBlank() || price.isEmpty();
    }
}
