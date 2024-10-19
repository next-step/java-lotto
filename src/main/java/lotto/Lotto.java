package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Lotto {

    private static final String DELIMITER = ",";
    private final List<Integer> lottoNumbers;

    public Lotto(String textNumbers) {
        this(Arrays.stream(textNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingNumbers(List<Integer> otherLottoNumbers) {
        return (int) otherLottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return unmodifiableList(lottoNumbers);
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
