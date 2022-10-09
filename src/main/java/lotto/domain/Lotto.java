package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money PRICE = new Money(1000);
    public static final int SIZE_OF_NUMBERS = 6;

    private final List<LottoNumber> sortedNumbers;

    public Lotto(List<LottoNumber> numbers) {
        List<LottoNumber> sortedNumbers = getDistinctSortedLottoNumbers(numbers);
        validate(sortedNumbers);
        this.sortedNumbers = sortedNumbers;
    }

    private List<LottoNumber> getDistinctSortedLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format("로또는 %d개의 번호로 구성되어야 합니다.", SIZE_OF_NUMBERS));
        }
    }

    public int countMatchNumbers(Lotto lotto) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(this.sortedNumbers);
        return (int) lotto.sortedNumbers.stream()
                .filter(lottoNumberSet::contains)
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return sortedNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(sortedNumbers, that.sortedNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortedNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "sortedNumbers=" + sortedNumbers +
                '}';
    }

    public boolean contains(LottoNumber number) {
        return sortedNumbers.stream()
                .anyMatch(sortedNumber -> sortedNumber.equals(number));
    }

}
