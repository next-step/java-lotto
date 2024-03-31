package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        List<LottoNumber> lottoNumberList = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumberList);
    }

    public boolean contains(LottoNumber value) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.equals(value));
    }

    public int size() {
        return lottoNumbers.size();
    }

    public long[] toArray() {
        return IntStream.range(0, size())
                .mapToLong(i -> lottoNumbers.get(i).getValue())
                .toArray();
    }

    public List<LottoNumber> getNumberList() {
        return this.lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoNumbers1 = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, lottoNumbers1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
