import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private Set<Integer> numbers = new HashSet<>();

    public Lotto() {
        while (numbers.size() < 6) {
            numbers.add(RandomUtils.getRandomNumber(45));
        }
    }

    public Lotto(int... numbers) {
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
