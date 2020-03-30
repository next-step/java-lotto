package step3.domain;

public class LottoInfo {
    private int lottoPrice = 0;

    public LottoInfo(int lottoPrice) {
        validateLottoInfo(lottoPrice);
        this.lottoPrice = lottoPrice;
    }

    private void validateLottoInfo(int lottoPrice) {
        if (lottoPrice <= 0 ){
            throw new IllegalArgumentException("로또 판매가격은 0보다 커야합니다.");
        }
    }

    public int getLottoPrice() {
        return lottoPrice;
    }
}
