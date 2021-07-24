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
class LottoPrizeTempTest {

    @DisplayName("당첨된 갯수를 넘겨주면 해당하는 등수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void getPrizeByMatchCount(int matchCount, boolean bonusMatch, LottoPrizeTemp expectedLottoPrize) {
        assertThat(LottoPrizeTemp.of(matchCount, bonusMatch)).isEqualTo(expectedLottoPrize);
    }

    private static Stream<Arguments> getPrizeByMatchCount() {
        return Stream.of(
                Arguments.of(6, true, LottoPrizeTemp.FIRST),
                Arguments.of(6, false, LottoPrizeTemp.FIRST),
                Arguments.of(5, true, LottoPrizeTemp.SECOND),
                Arguments.of(5, false, LottoPrizeTemp.THIRD),
                Arguments.of(4, true, LottoPrizeTemp.FOURTH),
                Arguments.of(4, false, LottoPrizeTemp.FOURTH),
                Arguments.of(3, true, LottoPrizeTemp.FIFTH),
                Arguments.of(3, false, LottoPrizeTemp.FIFTH),
                Arguments.of(2, true, LottoPrizeTemp.NONE),
                Arguments.of(2, false, LottoPrizeTemp.NONE),
                Arguments.of(1, true, LottoPrizeTemp.NONE),
                Arguments.of(1, false, LottoPrizeTemp.NONE),
                Arguments.of(0, true, LottoPrizeTemp.NONE),
                Arguments.of(0, false, LottoPrizeTemp.NONE)
        );
    }

    @DisplayName("상금이 있는 등수만 뽑아내기.")
    @Test
    void getWinningPrize() {
        List<LottoPrizeTemp> winningPrizes = LottoPrizeTemp.getWinningPrizes();

        assertThat(winningPrizes).doesNotContain(LottoPrizeTemp.NONE);
        assertThat(winningPrizes.size()).isNotZero();
    }

}
