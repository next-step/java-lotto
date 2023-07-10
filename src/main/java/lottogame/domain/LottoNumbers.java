package lottogame.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> values;

    public LottoNumbers(List<Integer> lottoNumbers) {
        assertLottoNumbers(lottoNumbers);
        this.values = lottoNumbers;
    }

    private void assertLottoNumbers(List<Integer> lottoNumbers) {

        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 Null이 되면 안됩니다.");
        }

        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                String.format("lottoNumbers의 size는 %d 이여야 합니다. lottoNumbers.size() \"%d\"", LOTTO_NUMBERS_SIZE,
                    lottoNumbers.size()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumbers)) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
            "lottoNumbers=" + values +
            '}';
    }
}
