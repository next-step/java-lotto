package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberSelectRule implements LottoNumberSelectRule {

    @Override
    public List<Integer> select() {
        Collections.shuffle(Lotto.CANDIDATE_NUMBERS);
        return new ArrayList<>(Lotto.CANDIDATE_NUMBERS.subList(0, Lotto.COUNT_OF_NUMBERS));
    }
}
