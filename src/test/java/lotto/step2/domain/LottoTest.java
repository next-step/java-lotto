package lotto.step2.domain;

import lotto.step2.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또는 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void lotto_숫자6개구성(int[] input, int[] expected) {
        Lotto lotto = Lotto.of(input);
        assertThat(lotto).isEqualTo(Lotto.of(expected));
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9, 11}),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 31}, new int[]{5, 10, 13, 17, 29, 31}),
                Arguments.of(new int[]{21, 33, 34, 37, 40, 45}, new int[]{21, 33, 34, 37, 40, 45})
        );
    }

    @DisplayName("6개의 숫자로 구성 안되서 에러처리")
    @ParameterizedTest
    @MethodSource("provideWrongLotto")
    void lotto_6개구성_실패(int[] input) {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.of(input);
        }).isInstanceOf(LottoException.class)
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");
    }

    private static Stream<Arguments> provideWrongLotto() {
        return Stream.of(
                Arguments.of(new int[]{7}),
                Arguments.of(new int[]{1, 3}),
                Arguments.of(new int[]{21, 33, 34}),
                Arguments.of(new int[]{1, 3, 5, 7}),
                Arguments.of(new int[]{5, 10, 13, 17, 29})
        );
    }

    @DisplayName("중복숫자 에러처리")
    @ParameterizedTest
    @MethodSource("provideOverLappedLotto")
    void lotto_숫자중복구성(int[] input) {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.of(input);
        }).isInstanceOf(LottoException.class)
                .hasMessage("중복된 숫자는 허용되지 않습니다.");
    }

    private static Stream<Arguments> provideOverLappedLotto() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5}),
                Arguments.of(new int[]{1, 3, 5, 6, 7, 3}),
                Arguments.of(new int[]{21, 33, 34, 33, 15, 21}),
                Arguments.of(new int[]{1, 3, 5, 7, 5, 1}),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 5})
        );
    }
}
