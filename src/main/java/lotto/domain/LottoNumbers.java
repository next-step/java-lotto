package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_START_INCLUSIVE = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_NUMBERS_STRING_DELIMITER = ", ";

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers ofRandom() {
        List<LottoNumber> randomLottoNumbers = IntStream.range(LOTTO_NUMBERS_START_INCLUSIVE, LOTTO_NUMBERS_SIZE)
                .mapToObj(it -> LottoNumber.ofRandom())
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(randomLottoNumbers);
    }

    public LottoNumbers(String lottoNumbersString) {
        this(toLottoNumbers(lottoNumbersString));
    }

    private static List<LottoNumber> toLottoNumbers(String lottoNumbersString) {
        return Arrays.stream(lottoNumbersString.split(LOTTO_NUMBERS_STRING_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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
