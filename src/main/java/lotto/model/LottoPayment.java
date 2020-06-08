package lotto.model;

public class LottoPayment {

    private final int LOTTO_PRICE = 1000;
    private String inputPrice;

    public LottoPayment(String inputPrice) {
        if(validate(inputPrice)) {
            throw new IllegalArgumentException("금액을 입력해 주세요.");
        }
        this.inputPrice = inputPrice;
    }

    public int pay() {
        return getLottoCount();
    }

    private int getLottoCount(){
        int lottoPrice = Integer.parseInt(this.inputPrice);
        if(lottoPrice < LOTTO_PRICE) {
            return 0;
        }
        return lottoPrice / LOTTO_PRICE;
    }

    private boolean validate(String price){
        return price == null || price.isBlank() || price.isEmpty();
    }
}
