package lotto.domain.lotto;

import lotto.constants.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또번호를 생성한다, 보너스 번호가 당첨번호에 존재시 예외가 발생한다")
    public void create() {
        assertThatThrownBy(() -> WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨 결과를 확인한다. 2개 이하 일치시 당첨금은 없다.")
    @MethodSource("source")
    void match(List<Integer> list, Winning winning) {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = Lotto.of(list);
        assertThat(winningLotto.match(lotto) == winning).isTrue();
    }

    static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Winning.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Winning.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 45), Winning.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 44, 45), Winning.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 43, 44, 45), Winning.FIFTH),
                Arguments.of(Arrays.asList(40, 2, 42, 43, 44, 45), Winning.FAIL),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45), Winning.FAIL));
    }
}
