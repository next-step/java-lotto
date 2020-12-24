package step2.domain.lotto;

import step2.domain.Rank;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import static step2.domain.Rank.*;

public class RankTest {

    private static Stream<Arguments> rankTestArguments() {
        return Stream.of(Arguments.of(6L, false, FIRST),
                Arguments.of(5L, true, SECOND),
                Arguments.of(5L, false, THIRD),
                Arguments.of(4L, true, FOURTH),
                Arguments.of(3L, false, FIFTH),
                Arguments.of(2L, true, MISS),
                Arguments.of(1L, false, MISS),
                Arguments.of(0L, true, MISS));
    }

    @ParameterizedTest
    @MethodSource("rankTestArguments")
    @DisplayName("당첨 순위 테스트")
    void rankTest(long countOfMatch, boolean answerOfIncludedBonusNumber, Rank rank) {
        assertThat(getRank(countOfMatch, answerOfIncludedBonusNumber)).isEqualTo(rank);
    }
}
