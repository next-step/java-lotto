package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(final int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("복권의 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
