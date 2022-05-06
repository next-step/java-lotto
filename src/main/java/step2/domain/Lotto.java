package step2.domain;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int COUNT = 6;

    private final List<LottoNumber> values;

    public Lotto(PurchaseStrategy purchaseStrategy) {
        Set<String> numbers = purchaseStrategy.getNumbers(COUNT);
        validate(numbers);
        this.values = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private void validate(Set<String> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("주어진 번호의 수가 " + COUNT + "와 다릅니다.");
        }
    }

    public long calculateHitCount(Winner winner) {
        return values.stream()
                .filter(winner::isContain)
                .count();
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
                .sorted(Comparator.comparing(LottoNumber::getValue))
                .map(LottoNumber::toString)
                .collect(Collectors.joining(" "));
    }
}
