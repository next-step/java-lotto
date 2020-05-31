package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AutoLottoNumberSelectRule implements LottoNumberSelectRule {

    @Override
    public Set<Integer> select() {
        Collections.shuffle(Lotto.CANDIDATE_NUMBERS);
        return new HashSet<>(Lotto.CANDIDATE_NUMBERS.subList(0, Lotto.COUNT_OF_NUMBERS));
    }
}
