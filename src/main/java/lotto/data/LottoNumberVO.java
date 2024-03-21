package lotto.data;

import lotto.util.MessageUtils;

import java.util.Objects;
import java.util.stream.IntStream;

import static lotto.util.ConstUtils.MAXIMUM_LOTTO_RANGE;
import static lotto.util.ConstUtils.MINIMUM_LOTTO_RANGE;

public class LottoNumberVO {

    private final static LottoNumberVO[] lottoBalls = new LottoNumberVO[MAXIMUM_LOTTO_RANGE + 1];

    static {
        IntStream.rangeClosed(MINIMUM_LOTTO_RANGE, MAXIMUM_LOTTO_RANGE)
                .forEach(number -> lottoBalls[number] = new LottoNumberVO(number));
    }

    private final int lottoNumber;

    private LottoNumberVO(int lottoNumber) {
        validateLottoNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    public static LottoNumberVO selectLottoBall(int lottoNumber) {
        validateLottoNumber(lottoNumber);

        return lottoBalls[lottoNumber];
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoNumberVO that = (LottoNumberVO) object;
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

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_RANGE || lottoNumber > MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException(MessageUtils.LOTTO_RANGE_VALIDATION_MESSAGE);
        }
    }
}
