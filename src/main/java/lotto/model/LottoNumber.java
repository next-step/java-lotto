package lotto.model;


public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        checkRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void checkRange(Integer number) {
        if (number > MAXIMUM_NUMBER || number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("로또 숫자의 범위가 올바르지 않았습니다.");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }


}
