package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeSummary;
import org.junit.jupiter.api.Test;

public class PrizeSummaryTest {
    Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void prizeSummary() {
        // given
        Lottos lottos = new Lottos(List.of(Lotto.from(List.of(1, 2, 30, 31, 32, 33)),
                Lotto.from(List.of(1, 2, 3, 41, 42, 43)),
                Lotto.from(List.of(1, 2, 4, 40, 42, 43)),
                Lotto.from(List.of(1, 2, 3, 4, 41, 42))));

        // when
        PrizeSummary prizeSummary = lottos.getPrizeSummary(winningLotto);

        // then
        assertThat(prizeSummary.getPrizeSummary()).containsExactlyInAnyOrderEntriesOf(Map.of(
                Prize.NOTHING, 1,
                Prize.THREE_MATCHING, 2,
                Prize.FOUR_MATCHING, 1,
                Prize.FIVE_MATCHING, 0,
                Prize.SIX_MATCHING, 0
        ));
    }
}
