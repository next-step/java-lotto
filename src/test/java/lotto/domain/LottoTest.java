package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Utils.makeRangeNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    private Lotto lotto;

    static Stream<Arguments> checkWinningRank() {
        return Stream.of(
                arguments(makeRangeNumbers(1, 7), WinningRank.FIRST),
                arguments(makeRangeNumbers(2, 8), WinningRank.SECOND),
                arguments(makeRangeNumbers(3, 9), WinningRank.THIRD),
                arguments(makeRangeNumbers(4, 10), WinningRank.FOURTH),
                arguments(makeRangeNumbers(7, 13), WinningRank.FAIL)
        );
    }

    @Test
    @DisplayName("로또 1장 생성")
    void createLotto() {
        Numbers numbers = makeRangeNumbers(0, 7);

        lotto = new Lotto(() -> numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void checkWinningRank(Numbers numbers, WinningRank expectedWinningRank) {
        Numbers winningNumbers = makeRangeNumbers(1, 7);
        Lotto lotto = new Lotto(() -> numbers);

        WinningRank winningRank = lotto.checkWinningRank(winningNumbers);

        assertThat(winningRank).isEqualTo(expectedWinningRank);
    }

}
