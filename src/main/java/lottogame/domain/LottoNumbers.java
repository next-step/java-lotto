package lottogame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lottogame.domain.spi.NumberGenerator;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> values;

    LottoNumbers(NumberGenerator numberGenerator) {
        Objects.requireNonNull(numberGenerator, "numberGeneartor는 Null이 되면 안됩니다.");
        this.values = initLottoNumbers(numberGenerator.generate(LOTTO_NUMBERS_SIZE));
    }

    LottoNumbers(List<Integer> lottoNumbers) {
        this.values = initLottoNumbers(lottoNumbers);
    }

    private List<LottoNumber> initLottoNumbers(List<Integer> lottoNumbers) {
        assertLottoNumbers(lottoNumbers);
        return lottoNumbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }

    private void assertLottoNumbers(List<Integer> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "lottoNumbers는 Null이 되면 안됩니다.");

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
