package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {
    Lotto winningLotto;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 16, 17, 15, 18))));
    }

    @DisplayName("lottos의 로또들의 Rank 를 구한다. (NOTHING 제외)")
    @Test
    void classifyByRank() {
        LottoMatcher matcher = new LottoMatcher(winningLotto, lottos);
        assertThat(matcher.classifyByRank())
                .contains(new LottoResult(1, Rank.FIRST));
    }
}