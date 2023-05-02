package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class LottosTest {

    @Test
    void countMatching() {
        Lottos lottos = getLottos();
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        Map<Match, Long> matchs = lottos.countMatching(winningLotto);

        assertThat(matchs).containsValues(1L, 1L, 1L, 1L);
    }

    public static Lottos getLottos() {
        return new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9)));
    }
}