package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int TOTAL_PER_LOTTO = 6;

    private final Set<Integer> numbers;
    private final LottoRandomGenerator generator;

    public Lotto() {
        this.generator = new LottoRandomGenerator();
        this.numbers = create();
    }

    public Lotto(Long seed) {
        this.generator = new LottoRandomGenerator(seed);
        this.numbers = create();
    }

    public Lotto(LottoRandomGenerator generator) {
        this.generator = generator;
        this.numbers = create();
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int n) {
        return this.numbers.contains(n);
    }

    private Set<Integer> create() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < TOTAL_PER_LOTTO) {
            result.add(generator.pick());
        }
        return result;
    }
}
