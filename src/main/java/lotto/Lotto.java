package lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int TOTAL_PER_LOTTO = 6;
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private final Random random;

    private final Set<Integer> numbers;

    public Lotto() {
        this.random = new Random();
        this.numbers = create();
    }

    public Lotto(long seed) {
        this.random = new Random(seed);
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
            result.add(pick());
        }
        return result;
    }

    private int pick() {
        return this.random.nextInt(MAX_NUMBER_OF_LOTTO) + 1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(this.numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
        builder.append("]");
        return builder.toString();
    }

}
