package step4;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoEntry {
    public static final int LOTTO_NUMBER_SIZE = 6;

    protected final Set<LottoNumber> lottoNumbers;

    public LottoEntry(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        validate();
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("주어진 숫자의 갯수가 6보다 작거나 큽니다.");
        }
    }

    public int countMatches(LottoEntry lottoEntry) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoEntry::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoEntry lottoEntry = (LottoEntry) o;
        return Objects.equals(lottoNumbers, lottoEntry.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public String toNumbersString() {
        return "[" +
                lottoNumbers.stream()
                        .map(LottoNumber::toOutputString)
                        .collect(Collectors.joining(", "))
                + "]";
    }
}
