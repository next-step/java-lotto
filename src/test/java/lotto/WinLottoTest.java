package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLottoTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(List<Integer> lottoNumberList, Integer bonusNumber) {
        // given
        WinLotto self = new WinLotto(lottoNumberList, bonusNumber);

        // when
        WinLotto other = new WinLotto(new Lotto(lottoNumberList), LottoNumber.of(bonusNumber));

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(39, 40, 41, 42, 43, 44), 45)
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_createSource")
    void invalid_create(List<Integer> lottoNumberList, Integer bonusNumber) {
        // given
        assertThatThrownBy(() -> {
            new WinLotto(lottoNumberList, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(39, 40, 41, 42, 43, 44), 44)
        );
    }

    @ParameterizedTest
    @MethodSource("matchSource")
    @DisplayName("WinLotto 는 Lotto 와 협력하여 Prize 를 확인할 수 있다.")
    void match(List<Integer> targetNumbers, Prize result) {
        // given
        WinLotto self = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        Lotto lotto = new Lotto(targetNumbers);

        // then
        assertThat(self.match(lotto)).isEqualTo(result);
    }

    static Stream<Arguments> matchSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), FIRST),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), SECOND),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 8), THIRD),
                Arguments.of(Arrays.asList(3, 4, 5, 6, 7, 8), FOURTH),
                Arguments.of(Arrays.asList(4, 5, 6, 7, 8, 9), FIFTH),
                Arguments.of(Arrays.asList(5, 6, 7, 8, 9, 10), NONE),
                Arguments.of(Arrays.asList(6, 7, 8, 9, 10, 11), NONE),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), NONE)
        );
    }
}
