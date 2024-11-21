package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NONE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResult2Test {

    @ParameterizedTest
    @MethodSource("rankAndFrequency")
    void 등수의_빈도를_반환한다(Rank rank, Integer expected) {
        LottoResult2 lottoResult = new LottoResult2(Map.of(
                FIRST, 1,
                SECOND, 2,
                THIRD, 3,
                FOURTH, 4,
                FIFTH, 5,
                NONE, 6
        ), 0);

        assertThat(lottoResult.of(rank)).isEqualTo(expected);
    }

    private static Stream<Arguments> rankAndFrequency() {
        return Stream.of(
                Arguments.arguments(FIRST, 1),
                Arguments.arguments(SECOND, 2),
                Arguments.arguments(THIRD, 3),
                Arguments.arguments(FOURTH, 4),
                Arguments.arguments(FIFTH, 5),
                Arguments.arguments(NONE, 6)
        );
    }
}