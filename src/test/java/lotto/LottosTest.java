package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PrizeSummary;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void getPrizeSummary() {
        // given
        Lottos lottos = new Lottos(List.of(Lotto.from(List.of(1, 2, 30, 31, 32, 33)),
                Lotto.from(List.of(1, 2, 3, 41, 42, 43)),
                Lotto.from(List.of(1, 2, 3, 41, 42, 45)),
                Lotto.from(List.of(1, 2, 3, 4, 42, 43)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 42)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 43)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 45)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 6))
        ));

        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = LottoNumber.from(45);

        // when
        PrizeSummary prizeSummary = lottos.getPrizeSummary(winningLotto, bonusBall);

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
}
