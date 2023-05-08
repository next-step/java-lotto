package lotto.domain;

import lotto.domain.winning.WinningCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @Test
    @DisplayName("일치 숫자 비교")
    void match() {
        Lottos lottos = new Lottos(Arrays.asList(LottoFactory.createManualLotto("1, 2, 3, 15, 20, 9"),
                LottoFactory.createManualLotto("1, 2, 3, 10, 11, 12")));

        Lotto lotto = LottoFactory.createManualLotto("1, 2, 3, 7, 8, 9");
        LottoNo bonusBall = LottoNo.of(10);
        assertThat(lottos.matchesLottos(lotto, bonusBall)).containsExactly(WinningCount.FOUR, WinningCount.THREE);
    }
}
