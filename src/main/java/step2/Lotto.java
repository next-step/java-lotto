package step2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static final int ORIGIN = 1;
    private static final int BOUND = 46;
    private static final int NUMBER_COUNT = 6;

    private List<Integer> numbers;
    private final Random randomNumberGenerator;

    private Lotto(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Lotto create(Random randomNumberGenerator) {
        Lotto lotto = new Lotto(randomNumberGenerator);
        lotto.makeNumbers();

        return lotto;
    }

    private void makeNumbers() {
        numbers = Stream.generate(this::generateNumber)
            .limit(NUMBER_COUNT)
            .collect(Collectors.toList());
    }

    private int generateNumber() {
        return randomNumberGenerator.ints(ORIGIN, BOUND).iterator().nextInt();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
