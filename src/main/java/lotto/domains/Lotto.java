package lotto.domains;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotto {
    protected static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(int n1, int n2, int n3, int n4, int n5, int n6) {
        this(List.of(n1, n2, n3, n4, n5, n6));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 개수는 6개여야 합니다.");
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 숫자는 중복이 될 수 없습니다. 입력값: " + numbers);
        }

        this.numbers = numbers
                .stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(v -> v > 1)
                .findAny()
                .isPresent();
    }

    public Prize getPrize(Lotto winner) {
        long count = numbers.stream()
                .filter(num -> winner.numbers.contains(num))
                .count();

        return Prize.find(count);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
