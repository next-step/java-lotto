package step02.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    private final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumbers;

    private LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(Integer from, Integer to) {
        return new LottoNumbers(generate(from, to));
    }

    private static List<Integer> generate(Integer from, Integer to) {
        return Stream.iterate(from, n -> n + 1)
                .limit(to)
                .collect(Collectors.toList());
    }

    public List<Integer> generateLotto() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());
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
