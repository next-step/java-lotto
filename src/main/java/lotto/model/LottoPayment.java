package lotto.model;

public class LottoPayment {

    private final int LOTTO_PRICE = 1000;

    public int pay(String price) {
        return getLottoCount(price);
    }

    private int getLottoCount(String price){
        if(price == null) {
            throw new IllegalArgumentException("금액을 입력해 주세요.");
        }
        int lottoPrice = Integer.parseInt(price);
        if(lottoPrice < LOTTO_PRICE) {
            return 0;
        }
        return lottoPrice / LOTTO_PRICE;
    }
}
