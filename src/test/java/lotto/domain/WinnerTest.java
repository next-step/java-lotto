package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 당첨번호는_필수다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Game(input))
                .withMessage("당첨번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,,3,4,5,6", "1,나,3,4,5,6"})
    @DisplayName("당첨 번호는 쉼표로 구분된 숫자만 입력 가능하다.")
    void 당첨_번호_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Game(input))
                .withMessage("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("comparingIdenticalLottonumber")
    void 두_게임의_일치하는_로또번호_갯수를_확인한다(Game game1, Game game2, int expected) {
        int count = game1.countIdenticalLottonumber(game2);

        assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> comparingIdenticalLottonumber() {
        return Stream.of(
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(7, 8, 9, 10, 11, 12)), 0),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(1, 10, 20, 30, 40, 45)), 1),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(4, 5, 6, 7, 8, 9)), 3),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }
}
