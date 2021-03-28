package lotto.domain.machine;

import java.util.List;
import lotto.domain.Lotto;

public class TestLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate(List<Integer> candidates) {
        return new Lotto(10, 13, 44, 17, 20, 33);
    }
}
