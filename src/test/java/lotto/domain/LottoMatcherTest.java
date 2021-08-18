package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;

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

    @DisplayName("로또들의 랭크별 결과")
    @Test
    void matchWithWinningLottoNumbers() {
        Map<Rank, Integer> resultMap = LottoMatcher.matchWithWinningLottoNumbers(lottos, winningLotto);
        assertThat(resultMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(resultMap.get(Rank.SECOND)).isEqualTo(0);
        assertThat(resultMap.get(Rank.THIRD)).isEqualTo(0);
        assertThat(resultMap.get(Rank.FOURTH)).isEqualTo(0);
    }

    @DisplayName("로또들의 전체 값")
    @Test
    void calculateTotalRewardsRatio() {
        Map<Rank, Integer> resultMap = LottoMatcher.matchWithWinningLottoNumbers(lottos, winningLotto);
        assertThat(LottoMatcher.calculateTotalRewardsRatio(3000, resultMap))
                .isEqualTo(BigDecimal.valueOf(Rank.FIRST.getRewards())
                        .multiply(BigDecimal.valueOf(1))
                        .divide(BigDecimal.valueOf(3000 * 100.0), 2, RoundingMode.HALF_EVEN));
    }
}