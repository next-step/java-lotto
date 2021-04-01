package lotto.domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate(List<Integer> candidates) {
        Collections.shuffle(candidates);
        return new Lotto(new ArrayList<>(candidates.subList(0, 6)));
    }
}
