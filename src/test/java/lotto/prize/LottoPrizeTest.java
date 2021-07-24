package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("보너스 번호를 추가한 로또 당첨 enum 테스트")
class LottoPrizeTest {

    @DisplayName("당첨된 갯수를 넘겨주면 해당하는 등수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void getPrizeByMatchCount(int matchCount, boolean bonusMatch, LottoPrize expectedLottoPrize) {
        assertThat(LottoPrize.of(matchCount, bonusMatch)).isEqualTo(expectedLottoPrize);
    }

    private static Stream<Arguments> getPrizeByMatchCount() {
        return Stream.of(
                Arguments.of(6, true, LottoPrize.FIRST),
                Arguments.of(6, false, LottoPrize.FIRST),
                Arguments.of(5, true, LottoPrize.SECOND),
                Arguments.of(5, false, LottoPrize.THIRD),
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

    @DisplayName("상금이 있는 등수만 뽑아내기.")
    @Test
    void getWinningPrize() {
        List<LottoPrize> winningPrizes = LottoPrize.getWinningPrizes();

        assertThat(winningPrizes).doesNotContain(LottoPrize.NONE);
        assertThat(winningPrizes.size()).isNotZero();
    }

}
