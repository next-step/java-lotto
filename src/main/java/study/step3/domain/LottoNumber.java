package study.step3.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static String LOTTO_NULL_EXCEPTION = "당첨번호는 빈 값을 입력할 수 없습니다.";
    private final static String LOTTO_LIMIT_NUMBER_EXCEPTION = "로또 번호는 1보다 작거나 45보다 클 수 없습니다.";
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(convertToInt(validateLottoNumberString(lottoNumber)));
    }

    public LottoNumber(int lottoNumber) {
        validateLottoNumberMinMax(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static int convertToInt(String lottoNumber) {
        return Integer.parseInt(lottoNumber);
    }

    private static String validateLottoNumberString(String inputLottoNumbers) {
        if (Objects.isNull(inputLottoNumbers) || inputLottoNumbers.trim().isEmpty()){
            throw new IllegalArgumentException(LOTTO_NULL_EXCEPTION);
        }
        return inputLottoNumbers;
    }

    private void validateLottoNumberMinMax(int lottoNumbers) {
        if (lottoNumbers > LOTTO_MAX_NUMBER || lottoNumbers < LOTTO_MIN_NUMBER){
            throw new IllegalArgumentException(LOTTO_LIMIT_NUMBER_EXCEPTION);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber compareLottoNumber) {
        return this.lottoNumber - compareLottoNumber.lottoNumber;
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
}
