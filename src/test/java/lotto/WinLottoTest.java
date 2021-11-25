package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
}
