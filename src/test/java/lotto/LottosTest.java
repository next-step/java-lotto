package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeSummary;
import lotto.domain.Rank;
import lotto.domain.WinningCombo;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void getPrizeSummary() {
        // given
        Lottos lottos = new Lottos(List.of(
                Lotto.of(1, 2, 30, 31, 32, 33),
                Lotto.of(1, 2, 3, 41, 42, 43),
                Lotto.of(1, 2, 3, 41, 42, 45),
                Lotto.of(1, 2, 3, 4, 42, 43),
                Lotto.of(1, 2, 3, 4, 5, 42),
                Lotto.of(1, 2, 3, 4, 5, 43),
                Lotto.of(1, 2, 3, 4, 5, 45),
                Lotto.of(1, 2, 3, 4, 5, 6)
        ));
        WinningCombo winningCombo = WinningCombo.of(List.of(1, 2, 3, 4, 5, 6), 45);

        // when
        PrizeSummary prizeSummary = lottos.getPrizeSummary(winningCombo);

        // then
        assertThat(prizeSummary.getPrizeSummary()).containsExactlyInAnyOrderEntriesOf(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 2,
                Rank.FOURTH, 1,
                Rank.FIFTH, 2,
                Rank.MISS, 1
        ));
    }

    @Test
    void mergeLottos() {
        Lottos manualLottos = Lottos.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12));
        Lottos autoLottos = Lottos.of(List.of(11, 12, 13, 14, 15, 16), List.of(17, 18, 19, 20, 21, 22));
        assertThat(manualLottos.mergeLottos(autoLottos))
                .extracting(Lottos::getLottos)
                .asList()
                .containsExactly(Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(7, 8, 9, 10, 11, 12),
                        Lotto.of(11, 12, 13, 14, 15, 16),
                        Lotto.of(17, 18, 19, 20, 21, 22));
    }
}
