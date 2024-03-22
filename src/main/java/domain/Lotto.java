package domain;

import java.util.*;

public class Lotto {

    public static final int PRICE = 1_000;

    private final List<Integer> numbers;

    public Lotto() {
        this(RandomNumberGenerator.randomNumbers());
    }

    public Lotto(List<Integer> numbers) {
        assertListSizeOfSix(numbers);
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        this.numbers = newNumbers;
    }

    private void assertListSizeOfSix(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
    }

    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
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
