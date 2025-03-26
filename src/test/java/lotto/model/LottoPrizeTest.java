package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    private static Stream<Arguments> prizeTestGenerator() {
        return Stream.of(
                Arguments.of(6, false, LottoPrize.FIRST),
                Arguments.of(6, true, LottoPrize.FIRST),
                Arguments.of(5, false, LottoPrize.THIRD),
                Arguments.of(5, true, LottoPrize.SECOND),
                Arguments.of(4, true, LottoPrize.FOURTH),
                Arguments.of(4, false, LottoPrize.FOURTH),
                Arguments.of(3, true, LottoPrize.FIFTH),
                Arguments.of(3, false, LottoPrize.FIFTH),
                Arguments.of(2, true, LottoPrize.NONE),
                Arguments.of(2, false, LottoPrize.NONE),
                Arguments.of(1, true, LottoPrize.NONE),
                Arguments.of(1, false, LottoPrize.NONE),
                Arguments.of(0, true, LottoPrize.NONE),
                Arguments.of(0, false, LottoPrize.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("prizeTestGenerator")
    void 등수_판단(int matchCount, boolean matchBonus, LottoPrize expectedPrize) {
        LottoPrize rank = LottoPrize.valueOf(matchCount, matchBonus);

        assertThat(rank).isEqualTo(expectedPrize);
    }


}
