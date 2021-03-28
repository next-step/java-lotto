package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 46;
    private static final List<Integer> numbers = IntStream.range(BOUND_MIN, BOUND_MAX)
            .boxed()
            .collect(Collectors.toList());
    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this(autoNumbers());
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private static List<Integer> autoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0, NUMBER_OF_LOTTO_NUMBER));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> lottoNumbers() {
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
