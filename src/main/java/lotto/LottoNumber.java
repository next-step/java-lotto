package lotto;

import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private LottoNumber(String lottoNumberStr) {
        validateLottoNumberRange(Integer.parseInt(lottoNumberStr));
        this.lottoNumber = Integer.parseInt(lottoNumberStr);
    }

    public static LottoNumber from(int lottoNumber){
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber from(String lottoNumberStr){
        return new LottoNumber(lottoNumberStr);
    }

    public boolean validateLottoNumberRange(int lottoNumber){
        if(lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("로또번호 범위 유효성검증 오류");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    public int toInt() {
        return lottoNumber;
    }

}
