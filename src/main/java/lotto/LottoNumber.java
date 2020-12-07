package lotto;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String lottoNumberStr) {
        validateLottoNumberRange(Integer.parseInt(lottoNumberStr));
        this.lottoNumber = Integer.parseInt(lottoNumberStr);
    }
    public boolean validateLottoNumberRange(int lottoNumber){
        if(lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("로또번호 범위 유효성검증 오류");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    public int toInt() {
        return lottoNumber;
    }


}
