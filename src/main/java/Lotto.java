import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this(getRandomNumbers());
    }

    public Lotto(List<Integer> numbers) {
        Collections.sort(new ArrayList<>(numbers));
        this.numbers = numbers;
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

    public int rank(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.numbers();
        winningNumbers.retainAll(this.numbers());
        return winningNumbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
