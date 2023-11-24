package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusMatchingTest {
    private static Stream<Arguments> BooleanAndBonusMatching() {
        return Stream.of(
                Arguments.of(Rank.FIRST, true, false),
                Arguments.of(Rank.FIRST, false, true),
                Arguments.of(Rank.SECOND, true, true),
                Arguments.of(Rank.SECOND, false, false),
                Arguments.of(Rank.FOURTH, true, true),
                Arguments.of(Rank.FOURTH, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("BooleanAndBonusMatching")
    void from(Rank rank, boolean bonusMatching, boolean bonusMatchingResult) {
        assertThat(rank.getBonusMatching().match(bonusMatching)).isEqualTo(bonusMatchingResult);
    }
}
