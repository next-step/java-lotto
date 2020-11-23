package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.LottoCountBoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @MethodSource("createLottoMatchNumbers")
    @DisplayName("로또 티켓 맞는 갯수에 따라 맞는 숫자를 반환합니다.")
    void matchLotto(Lotto lotto, List<Integer> matchLotto, int expected) {
        assertThat(lotto.matchLottoNumbers(new Lotto(matchLotto))).isEqualTo(expected);
    }

    private static Stream<Arguments> createLottoMatchNumbers() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(6, 5, 4, 3, 2, 1), 6),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 2, 3, 4, 5, 6), 5),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 8, 3, 4, 5, 6), 4),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 8, 9, 4, 5, 6), 3),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 8, 9, 10, 5, 6), 2),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 8, 9, 10, 11, 6), 1),
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Arrays.asList(7, 8, 9, 10, 11, 12), 0));
    }


    @ParameterizedTest
    @MethodSource("createExceptionLotto")
    @DisplayName("로또 티켓 한장을 만들때 갯수가 넘거나 적으면 익셉션을 도출합니다.")
    void validLotto(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoCountBoundException.class);
    }

    private static Stream<Arguments> createExceptionLotto() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }
}
