package step2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private static final int SIZE_OF_LOTTO = 6;
    private final Set<Number> lotto;

    public Lotto(Set<Number> lotto) {
        this.lotto = lotto;
    }

    public static Lotto buy() {
        return new Lotto(getRandom());
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

    private static boolean isLottoSize(Set<Number> numbers) {
        return numbers.size() == SIZE_OF_LOTTO;
    }
}
