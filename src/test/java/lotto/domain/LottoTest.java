package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    private Lotto lotto;

    static Stream<Arguments> checkWinningRank() {
        Numbers.Builder builder = Numbers.builder();
        return Stream.of(
                arguments(builder.range(1, 7).build(), WinningRank.FIRST),
                arguments(builder.range(2, 8).build(), WinningRank.SECOND),
                arguments(builder.range(3, 9).build(), WinningRank.THIRD),
                arguments(builder.range(4, 10).build(), WinningRank.FOURTH),
                arguments(builder.range(5, 11).build(), WinningRank.FAIL)
        );
    }

    @Test
    @DisplayName("로또 1장 생성")
    void createLotto() {
        Numbers numbers = Numbers.builder().range(1, 7).build();

        lotto = new Lotto(() -> numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void checkWinningRank(Numbers numbers, WinningRank expectedWinningRank) {
        Numbers winningNumbers = Numbers.builder().range(1, 7).build();
        Lotto lotto = new Lotto(() -> numbers);

        WinningRank winningRank = lotto.checkWinningRank(winningNumbers);

        assertThat(winningRank).isEqualTo(expectedWinningRank);
    }

}
