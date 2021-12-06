package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public static Lotto newInstance() {
        return new Lotto();
    }

    public static Lotto newInstance(List<Integer> answer) {
        LottoNumbers.valid(answer);
        return new Lotto(new ArrayList<>(answer));
    }

    public Lotto() {
        numbers = LottoNumbers.autoNumbers();
    }

    public Lotto(List<Integer> answer) {
        LottoNumbers.valid(answer);
        numbers = new ArrayList<>(answer);
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }
}
