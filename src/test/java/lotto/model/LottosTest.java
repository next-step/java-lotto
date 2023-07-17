package lotto.model;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lotto createLotto(int... ints) {
        return new Lotto(Arrays.stream(ints)
            .boxed()
            .map(LottoNumber::new)
            .collect(toList()));
    }

    private List<Lotto> createLottos(Lotto... lottos) {
        return Arrays.stream(lottos)
            .collect(toList());
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또 비교")
    void 구매로또_당첨로또_비교() {
        // given
        Lottos purChasedLotto = new Lottos(
            createLottos(
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 4, 6, 8, 10, 12)));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Map<Rank, Integer> matchResult = purChasedLotto.calculateMatchLotto(winningLotto);

        // then
        assertThat(matchResult.get(Rank.THREE)).isEqualTo(1);
        assertThat(matchResult.get(Rank.FOUR)).isEqualTo(0);
        assertThat(matchResult.get(Rank.FIVE)).isEqualTo(0);
        assertThat(matchResult.get(Rank.FIVE_WITH_BONUS)).isEqualTo(0);
        assertThat(matchResult.get(Rank.SIX)).isEqualTo(2);
    }
}
