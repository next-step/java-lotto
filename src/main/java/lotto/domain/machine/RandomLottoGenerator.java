package lotto.domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate(List<LottoBall> candidates) {
        Collections.shuffle(candidates);
        return new Lotto(new ArrayList<>(candidates.subList(0, 6)));
    }
}
