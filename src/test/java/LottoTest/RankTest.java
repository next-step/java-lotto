package LottoTest;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringaddcalculator.Operands;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @ParameterizedTest
    @DisplayName("ValueOf 테스트")
    @MethodSource("provideInput")
    void Given_CountOfMatch_MatchBonus_When_ValueOf_Then_Rank(int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FORTH),
                Arguments.of(4, true, Rank.FORTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(3, true, Rank.FIFTH)
        );
    }
}
