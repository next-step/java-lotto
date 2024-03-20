import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this(getRandomNumbers());
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

    private static List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

    public Rank rank(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.numbers();
        winningNumbers.retainAll(this.numbers());
        return Rank.of(winningNumbers.size());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private static class LottoNumberGenerator {

//        private static final List
    }
}
