package lotto;

import lotto.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @DisplayName("로또 번호와 보너스볼에 따라 상금을 구한다")
    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    void lottoPrizeWithBonus(int rankCount, boolean matchBonus, int winningMoney) {
        LottoPrize lottoPrize = LottoPrize.of(rankCount, matchBonus);
        assertThat(lottoPrize.money()).isEqualTo(winningMoney);
    }

    static Stream<Arguments> lottoNumbersAndRank() {
        return Stream.of(
                Arguments.of(6, false, 2_000_000_000),
                Arguments.of(5, true, 30_000_000),
                Arguments.of(5, false, 1_500_000),
                Arguments.of(4, false, 50_000),
                Arguments.of(3, false, 5_000)
        );
    }
}
