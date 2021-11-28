package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @DisplayName("matchedCount에 따라 Rank enum을 생성하는지 검증")
    @ParameterizedTest
    @MethodSource("fromParameter")
    void fromTest(int matchedCount, boolean isMatchedBonus, Rank expected) {
        assertThat(Rank.from(matchedCount, isMatchedBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> fromParameter() {
        return Stream.of(Arguments.of(3, false, Rank.FIFTH),
                         Arguments.of(4, false, Rank.FOURTH),
                         Arguments.of(5, false, Rank.THIRD),
                         Arguments.of(5, true, Rank.SECOND),
                         Arguments.of(6, false, Rank.FIRST));
    }

    @DisplayName("from메서드에 Rank enum에 맞지 않는 값이 들어오면 MISS를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 7, 8 })
    void invalidFromTest(int matchedCount) {
        assertThat(Rank.from(matchedCount, true)).isEqualTo(Rank.MISS);
    }
}
