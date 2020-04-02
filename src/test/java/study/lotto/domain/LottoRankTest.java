package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.LottoRank;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @DisplayName("당첨 갯수와 보너스 여부에 따라 알맞은 등수가 나온다.")
    @ParameterizedTest
    @MethodSource("provide")
    void valueOf(int matchCount, boolean matchBonus, LottoRank expect) {
        assertThat(LottoRank.valueOf(matchCount, matchBonus)).isEqualTo(expect);
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(0, true, LottoRank.MISS)
        );
    }
}
