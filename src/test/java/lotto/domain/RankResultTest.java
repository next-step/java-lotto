package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RankResultTest {

    @Test
    void 모든_등수의_결과를_포함한다_성공() {
        Map<Rank, Integer> rankFrequency = Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableMap(
                        rank -> rank,
                        rank -> 0)
                );

        RankResult rankResult = new RankResult(rankFrequency);

        for (Rank rank : Rank.values()) {
            assertThat(rankResult.of(rank)).isNotNull();
        }
    }

    @Test
    void 모든_등수의_결과를_포함한다_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RankResult(Map.of(Rank.FIRST, 0)))
                .withMessage("모든 등수의 결과가 포함되어야 합니다.");
    }

    @Test
    void 등수의_빈도는_반드시_0이상이다() {
        Map<Rank, Integer> rankFrequency = Arrays.stream(Rank.values())
                .collect(Collectors.toUnmodifiableMap(
                        rank -> rank,
                        rank -> -1)
                );

        assertThatIllegalArgumentException().isThrownBy(() -> new RankResult(rankFrequency))
                .withMessage("빈도는 음수일 수 없습니다.");
    }
}