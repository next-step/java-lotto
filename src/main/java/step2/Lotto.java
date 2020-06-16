package step2;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private static final int SIZE_OF_LOTTO = 6;
    private final Set<Number> lotto;

    public Lotto(Set<Number> lotto) {
        checkSize(lotto);
        this.lotto = new HashSet<>(lotto);
    }

    public static Lotto buy() {
        return new Lotto(getRandom());
    }

    public static Lotto win(Set<Number> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto mock(Set<Number> numbers) {
        return new Lotto(numbers);
    }

    public Set<Number> getLotto() {
        return lotto;
    }

    public static Set<Number> getRandom() {
        Set<Number> numbers = new HashSet<>();
        while(!isLottoSize(numbers)) {
            numbers.add(Number.random());
        }
        return numbers;
    }

    private void checkSize(Set<Number> lotto) {
        if(!isLottoSize(lotto)) {
            throw new IllegalArgumentException(Error.NOT_REQUIRED_SIZE);
        }
    }

    private static boolean isLottoSize(Set<Number> numbers) {
        return numbers.size() == SIZE_OF_LOTTO;
    }

    public int compare(Lotto win) {
        return (int) lotto.stream()
                .filter(number -> win.contains(number))
                .count();
    }

    private boolean contains(Number number) {
        return lotto.contains(number);
    }
}
