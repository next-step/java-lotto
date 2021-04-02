package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class TestLottoGenerator implements LottoGenerator {
    private int offset;

    public TestLottoGenerator(int offset) {
        this.offset = offset;
    }

    @Override
    public Lotto generate(List<LottoBall> candidates) {
        Lotto lotto = new Lotto(1 + offset,2 + offset, 3 + offset,
                4 + offset, 5 + offset, 6 + offset);
        offset += 1;
        return lotto;
    }
}
