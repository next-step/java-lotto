package lottery;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottery {
    private static final Integer NUM_NUMBERS = 6;
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 50;

    private final Set<Integer> numbers;

    private Lottery() {
        numbers = new HashSet<>();
    }

    public static Lottery fromRandom() {
        Lottery lottery = new Lottery();
        Random random = new Random();
        while (lottery.numbers.size() < NUM_NUMBERS) {
            lottery.numbers.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }
        return lottery;
    }

    public static Lottery fromGiven(Set<Integer> numbers) {
        Lottery lottery = new Lottery();
        lottery.numbers.addAll(numbers);
        return lottery;
    }

    public Set<Integer> getNumbers() {
        return new HashSet<>(numbers);
    }
}
