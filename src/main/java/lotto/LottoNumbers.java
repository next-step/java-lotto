package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers publish(ShuffleStrategy shuffleStrategy) {
        checkNotNull(shuffleStrategy);
        List<LottoNumber> lottoNumbers = LottoNumber.listOf(LOTTO_NUMBERS_SIZE, shuffleStrategy);
        return new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkNotNull(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void checkNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
