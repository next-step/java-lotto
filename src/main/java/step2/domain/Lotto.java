package step2.domain;


import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COUNT = 6;
    private static final String DELIMITER = ", ";

    private final Set<LottoNumber> values;

    public Lotto(NumberProvider numberProvider) {
        validateNull(numberProvider);
        Set<String> numbers = numberProvider.getNumbers(COUNT);
        validateSize(numbers);
        this.values = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    public Lotto(String numbers) {
        validateNull(numbers);
        List<String> splits = List.of(numbers.split(DELIMITER));
        this.values = splits.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    private <T> void validateNull(T param) {
        if (param == null) {
            throw new IllegalArgumentException("주어진 파라미터가 널 입니다.");
        }
    }

    private void validateSize(Set<String> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("주어진 번호의 수가 " + COUNT + "와 다릅니다.");
        }
    }

    public boolean contain(LottoNumber operand) {
        return values.stream()
                .anyMatch(operand::equals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(values, lotto.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.stream()
                .sorted(LottoNumber::compareTo)
                .map(LottoNumber::toString)
                .collect(Collectors.joining(" "));
    }
}
