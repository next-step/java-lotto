package step3;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoEntry {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 46;
    public static final int LOTTO_NUMBER_SIZE = 6;

    protected final Set<Integer> lottoNumbers;

    public LottoEntry(List<Integer> numbers) {
        this.lottoNumbers = new LinkedHashSet<>(numbers);
        validate();
    }

    private void validate() {
        if (this.lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("주어진 숫자의 갯수가 6보다 작거나 큽니다.");
        }
    }

    public int countMatch(LottoEntry lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return this.lottoNumbers.contains(number);
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
                this.lottoNumbers.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "]";
    }
}
