package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberSelectRule implements LottoNumberSelectRule {

    @Override
    public List<Integer> select() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        return new ArrayList<>(CANDIDATE_NUMBERS.subList(0, Lotto.COUNT_OF_NUMBERS));
    }
}
