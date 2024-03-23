package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoFactory implements LottoFactory {

    @Override
    public Lotto create() {
        return new Lotto(RandomNumberGenerator.randomNumbers());
    }

    private static class RandomNumberGenerator {

        private static final List<Integer> numbers;

        static {
            numbers = new ArrayList<>();
            for (int i = 1; i <= 45; i++) {
                numbers.add(i);
            }
        }

        public static List<Integer> randomNumbers() {
            List<Integer> newNumbers = new ArrayList<>(RandomNumberGenerator.numbers);
            Collections.shuffle(newNumbers);
            return newNumbers.subList(0, 6);
        }
    }
}
