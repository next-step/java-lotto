package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.type.Prize;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {

    @ParameterizedTest
    @MethodSource("lottoWithPrize")
    @DisplayName("일치 개수와 보너스 일치에 따라 당첨을 계산할 수 있다")
    public void prize(int matchCount, boolean isBonusMatched, Prize prize) {
        assertThat(Prize.of(matchCount, isBonusMatched)).isEqualTo(prize);
    }

    private static Stream<Arguments> lottoWithPrize() {
        return Stream.of(
            Arguments.arguments(6, false, Prize.FIRST),
            Arguments.arguments(5, true, Prize.SECOND),
            Arguments.arguments(5, false, Prize.THIRD),
            Arguments.arguments(1, false, Prize.NO_PRIZE)
        );
    }

}
