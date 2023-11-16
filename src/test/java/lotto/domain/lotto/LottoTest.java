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

class LottoTest {
    @Test
    @DisplayName("로또를 생성한다. 로또 번호는 1 ~ 45사이의 숫자이어여 하고 총 6자리 이어야 한다. 아니면 예외가 발생한다.")
    void create() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.of(Arrays.asList(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "번호를 비교하여 중복되는 번호의 수를 리턴한다")
    @MethodSource("generateData")
    void match(int excepted, List<Integer> list) {
        Lotto jackpot = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.of(list);
        assertThat(jackpot.match(lotto)).isEqualTo(excepted);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(5, Arrays.asList(1, 2, 3, 4, 5, 45)),
                Arguments.of(4, Arrays.asList(1, 2, 3, 4, 44, 45)),
                Arguments.of(3, Arrays.asList(1, 2, 3, 43, 44, 45)),
                Arguments.of(2, Arrays.asList(1, 2, 42, 43, 44, 45)),
                Arguments.of(1, Arrays.asList(1, 41, 42, 43, 44, 45)),
                Arguments.of(0, Arrays.asList(40, 41, 42, 43, 44, 45)));
    }

    @Test
    @DisplayName("현재 로또에 2등 번호의 존재 여부를 리턴한다")
    void bonusMatch() {
        assertThat(Lotto.of(1, 2, 3, 4, 5, 6).bonusMatch(LottoNumber.of(1))).isTrue();
        assertThat(Lotto.of(1, 2, 3, 4, 5, 6).bonusMatch(LottoNumber.of(45))).isFalse();
    }

    @ParameterizedTest(name = "당첨 결과를 확인한다. 2개 이하 일치시 당첨금은 없다.")
    @MethodSource("source")
    void match(List<Integer> list, Winning winning) {
        Lotto jackpot = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.of(list);
        assertThat(lotto.match(jackpot, LottoNumber.of(7))).isEqualTo(winning);
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
