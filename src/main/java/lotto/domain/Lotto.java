package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int TOTAL_PER_LOTTO = 6;

    private final Set<Integer> numbers;

    public Lotto() {
        this(new LottoRandomGenerator());
    }

    public Lotto(Long seed) {
        this(new LottoRandomGenerator(seed));
    }

    public Lotto(LottoRandomGenerator generator) {
        this(generator.generate(TOTAL_PER_LOTTO));
    }

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int n) {
        return this.numbers.contains(n);
    }
}
