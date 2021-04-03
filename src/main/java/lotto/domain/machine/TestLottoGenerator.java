package lotto.domain.machine;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class TestLottoGenerator implements LottoGenerator {
    private int startOffset;

    public TestLottoGenerator(int startOffset) {
        this.startOffset = startOffset;
    }

    @Override
    public Lotto generate(List<LottoBall> candidates) {
        Lotto lotto = new Lotto(1 + startOffset, 2 + startOffset, 3 + startOffset,
                4 + startOffset, 5 + startOffset, 6 + startOffset);
        startOffset += 1;
        return lotto;
    }
}
