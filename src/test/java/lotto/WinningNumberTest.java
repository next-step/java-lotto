package lotto;

import lotto.domain.LotteryNumbers;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

public class WinningNumberTest {

    @DisplayName("당첨번호와 추출한 숫자 중 일치하는 갯수를 구한다.")
    @Test
    void matchWinningNumber() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        int matchCount = lotto.matchWinningCount(lotteryNumbers.getWinningNumbers());
        Assertions.assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스번호가 추출한 숫자 중 일치하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("generateArgumentsSet")
    void isMatchBonusNumber(Set<Integer> numbers, boolean expectResult) {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.isMatchBonus(lotteryNumbers.getBonusNumber())).isEqualTo(expectResult);
    }

    private static Stream<Arguments> generateArgumentsSet() {
        return Stream.of(
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 6), false),
                Arguments.arguments(Set.of(1, 2, 3, 4, 5, 7), true)
        );
    }

}
