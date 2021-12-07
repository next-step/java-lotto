package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private int bonus;

    private Lotto() {
        numbers = LottoNumbers.autoNumbers();
    }

    private Lotto(List<Integer> answer) {
        LottoNumbers.valid(answer);
        numbers = new ArrayList<>(answer);
    }

    private Lotto(List<Integer> answer, int bonus) {
        LottoNumbers.valid(answer);
        numbers = new ArrayList<>(answer);
        this.bonus = bonus;
    }

    public static Lotto newInstance() {
        return new Lotto();
    }

    public static Lotto newInstance(List<Integer> answer) {
        LottoNumbers.valid(answer);
        return new Lotto(new ArrayList<>(answer));
    }

    public static Lotto newInstance(List<Integer> answer, LottoNumber bonus) {
        LottoNumbers.valid(answer);
        return new Lotto(new ArrayList<>(answer), bonus.getLottoNumber());
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

    public int getBonus() {
        return bonus;
    }
}
