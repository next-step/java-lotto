package step2;

import java.util.*;

public class Lotto {

    private static final Random random = new Random();
    private final List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        while (numbers.size() < 6) {
            addLottoNumber(createRandomNumber());
        }
    }

    public Lotto(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    private int createRandomNumber() {
        return random.nextInt(45) + 1;
    }

    private void addLottoNumber(int num) {
        if (!numbers.contains(num)) {
            numbers.add(num);
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
