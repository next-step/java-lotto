package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Lotto {

    private static final String DELIMITER = ",";
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public Lotto(String textNumbers) {
        this(Arrays.stream(textNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> lottoNumbers) {
        throwIfInvalidSize(lottoNumbers);
        throwIfInvalidRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingNumbers(Lotto otherLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(otherLottoNumbers.lottoNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return unmodifiableList(lottoNumbers);
    }

    private static void throwIfInvalidSize(List<Integer> lottoNumbers) throws IllegalArgumentException {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("6자리의 숫자가 필요합니다.");
        }
    }

    private static void throwIfInvalidRange(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER)
                .forEach(lottoNumber -> {
                    throw new IllegalArgumentException("1 이상 45 이하의 값만 허용합니다.");
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
