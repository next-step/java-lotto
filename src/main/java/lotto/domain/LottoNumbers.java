package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    private static final String NULL_NOT_ALLOW_MESSAGE = "null은 허용되지 않습니다.";
    private static final String LOTTO_SIZE_NOT_MATCH_MESSAGE = "로또 번호 개수가 일치하지 않습니다.";
    private static final String LOTTO_NUMBERS_STRING_DELIMITER = ", ";
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbersString) {
        this(wrap(lottoNumbersString));
    }

    LottoNumbers(List<LottoNumber> lottoNumbers) {
        this(toSet(lottoNumbers));
    }

    LottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_NOT_MATCH_MESSAGE);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers ofRandom() {
        return new LottoNumbers(RandomLottoNumbersGenerator.generate());
    }

    static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(wrap(numbers));
    }

    private static Set<LottoNumber> toSet(List<LottoNumber> lottoNumbers) {
        return new HashSet<>(lottoNumbers);
    }

    private static List<LottoNumber> wrap(String lottoNumbersString) {
        if (lottoNumbersString == null) {
            throw new IllegalArgumentException(NULL_NOT_ALLOW_MESSAGE);
        }

        return Arrays.stream(lottoNumbersString.split(LOTTO_NUMBERS_STRING_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> wrap(List<Integer> numbers) {
        return numbers.stream()
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
