package lottogame.domain;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    LottoNumber(int lottoNumber) {
        assertLottoNumber(lottoNumber);
    }

    private void assertLottoNumber(final int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 %d에서 %d 사이 값이어야 합니다 \"%d\"", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, lottoNumber));
        }
    }

}
