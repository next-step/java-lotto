package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCountWith(Lotto other) {
        Set<Integer> union = new HashSet<>(numbers);
        union.addAll(other.numbers);
        return LOTTO_SIZE * 2 - union.size();
    }

    public boolean matchBonus(int bonusBall) {
        return numbers.contains(bonusBall);
    }
}
