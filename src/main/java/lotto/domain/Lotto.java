package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money PRICE = new Money(1000);
    public static final int SIZE_OF_NUMBERS = 6;

    private final List<LottoNumber> sortedNumbers;

    public Lotto(List<LottoNumber> numbers) {
        List<LottoNumber> sortedNumbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        validate(sortedNumbers);
        this.sortedNumbers = sortedNumbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format("로또는 %d개의 번호로 구성되어야 합니다.", SIZE_OF_NUMBERS));
        }
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

}
