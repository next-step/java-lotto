package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    
    @Test
    void 일치_개수로_등수를_찾을_수_있다() {
        assertThat(LottoRank.fromMatchCount(6)).isEqualTo(FIRST);
        assertThat(LottoRank.fromMatchCount(5)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.fromMatchCount(4)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.fromMatchCount(3)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.fromMatchCount(2)).isEqualTo(null);
    }
    
    @Test
    void 당첨_통계에서_각_등수별_당첨_개수를_셀_수_있다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> purchasedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 3등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 4등
                new Lotto(List.of(1, 2, 10, 11, 12, 13)) // 꽝
        );

        Map<LottoRank, Long> rankCount = purchasedLotto.stream()
                .map(lotto -> lotto.matchCount(winningLotto))
                .map(LottoRank::fromMatchCount)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        assertThat(rankCount.get(FIRST)).isEqualTo(1L);
        assertThat(rankCount.get(SECOND)).isEqualTo(1L);
        assertThat(rankCount.get(THIRD)).isEqualTo(1L);
        assertThat(rankCount.get(FOURTH)).isEqualTo(1L);
    }
}
