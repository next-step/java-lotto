package step2.vo;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_START_NUMBER = 1;

    private static final int LOTTO_END_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 허용됩니다.");
        }
    }

    public boolean equalsWinNum(int winNum) {
        return lottoNumber == winNum;
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber - o.lottoNumber;
    }
}
