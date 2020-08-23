package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.PassivityLottoNumberGenerator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("WinningLotto를 만든다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1"})
    void of(String input) {
        WinningLotto winningLotto = WinningLotto.of(input, 7);

        assertThat(winningLotto).isEqualTo(WinningLotto.of("1,2,3,4,5,6", 7));
    }

    @DisplayName("유효하지 않은 번호로 WinningLotto를 만든면 Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"test", "1,2", "-1,2,3,4,5,6", "0,1,2,3,4,5", "2,3,4,5,6,7", "46,47,48,49,50,51", "1,2,3,4,5,6,8"})
    void of_invalidNumbers(String input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 7))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "generateData")
    void getRank(String winningLottoNumber, int bonusNumber, Rank expect) {
        Lotto lotto = Lotto.of("1,2,3,4,5,6", new PassivityLottoNumberGenerator());
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);

        Rank rank = winningLotto.getRank(lotto);

        assertThat(rank).isEqualTo(expect);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", 7, Rank.FIRST),
                Arguments.of("1,2,3,4,5,45", 6, Rank.SECOND),
                Arguments.of("1,2,3,4,5,45", 7, Rank.THIRD),
                Arguments.of("1,2,3,4,44,45", 6, Rank.FOURTH),
                Arguments.of("1,2,3,43,44,45", 6, Rank.FIFTH),
                Arguments.of("1,2,22,23,24,25", 6, Rank.MISS),
                Arguments.of("1,21,22,23,24,25", 6, Rank.MISS),
                Arguments.of("20,21,22,23,24,25", 6, Rank.MISS)
        );
    }
}
