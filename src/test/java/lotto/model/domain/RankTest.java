package lotto.model.domain;


import lotto.model.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("당첨번호_개수와_보너스볼_보유여부로_랭크계산_테스트케이스")
    void 당첨번호_개수와_보너스볼_보유여부로_랭크계산_성공(int matchCount, boolean hasBonusBall, Rank result) {
        // given, when, then
        assertThat(Rank.valueOf(matchCount, hasBonusBall)).isEqualTo(result);
    }

    static Stream<Arguments> 당첨번호_개수와_보너스볼_보유여부로_랭크계산_테스트케이스() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(1, true, Rank.NONE),
                Arguments.of(0, false, Rank.NONE)
        );
    }
}
