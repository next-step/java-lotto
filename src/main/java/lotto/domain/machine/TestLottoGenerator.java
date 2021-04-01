package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class TestLottoGenerator implements LottoGenerator {
    private int offset = 0;

    @Override
    public Lotto generate(List<Integer> candidates) {
        Lotto lotto = new Lotto(1 + offset,2 + offset, 3 + offset,
                4 + offset, 5 + offset, 6 + offset);
        offset += 1;
        return lotto;
    }
}
