package lotto.domain;

public class LottoNumber {

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validateNumberRange(lottoNum);

        this.lottoNum = lottoNum;
    }

    private void validateNumberRange(final int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("복권의 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
