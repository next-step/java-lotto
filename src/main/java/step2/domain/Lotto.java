package step2.domain;


import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int COUNT = 6;
    private static final String DELIMITER = ", ";

    private final Set<LottoNumber> values;

    public Lotto(String input) {
        validateNull(input);
        List<String> numbers = List.of(input.split(DELIMITER));
        validateLength(numbers);
        validateDuplicate(numbers);
        this.values = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    private void validateNull(String numbers) {
        if (numbers == null || numbers.isBlank()) {
            throw new IllegalArgumentException("입력 값이 Null 이거나 Blank 입니다.");
        }
    }

    private void validateLength(List<String> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("입력된 번호 갯수가 " + COUNT + " 가 아닙니다.");
        }
    }

    private void validateDuplicate(List<String> splits) {
        long distinctCount = splits.stream().distinct().count();
        if (distinctCount != splits.size()) {
            throw new IllegalArgumentException("입력 값에 중복된 번호가 있습니다.");
        }
    }

    public long calculateHitCount(Lotto operand) {
        return operand.values.stream()
                .filter(this::contain)
                .count();
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
