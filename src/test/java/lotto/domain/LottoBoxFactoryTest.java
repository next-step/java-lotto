package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.strategy.FrontExtractStrategy;
import org.junit.jupiter.api.Test;

class LottoBoxFactoryTest {

    @Test
    void 로또_맞춘_갯수_체크() {
        LottoBox lottoBox = LottoBoxFactory.createLottoBox(3, new FrontExtractStrategy(), List.of());
        Lotto correctLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(correctLotto, new LottoBall(10));
        List<WinningResult> correctInfos = lottoBox.retrieveCorrectNum(winningLotto);
        assertThat(correctInfos)
                .containsExactly(new WinningResult(6), new WinningResult(6), new WinningResult(6));
    }
}