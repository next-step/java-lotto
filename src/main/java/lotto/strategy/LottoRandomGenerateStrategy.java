package lotto.strategy;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class LottoRandomGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public Set<Integer> generateLotto() {
        Collections.shuffle(NUMBERS);
        return new TreeSet<>(NUMBERS.subList(0, 6));
    }
}
