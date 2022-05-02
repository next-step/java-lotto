package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_STRING_DELIMITER = ", ";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbersString) {
        this(toLottoNumbers(lottoNumbersString));
    }

    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers ofRandom() {
        List<LottoNumber> randomLottoNumbers = RandomLottoNumbersGenerator.generate();
        return new LottoNumbers(randomLottoNumbers);
    }

    private static List<LottoNumber> toLottoNumbers(String lottoNumbersString) {
        return Arrays.stream(lottoNumbersString.split(LOTTO_NUMBERS_STRING_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber::equals);
    }

    public int getMatchNumberCount(LottoNumbers lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
