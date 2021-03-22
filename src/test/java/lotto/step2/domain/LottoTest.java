package lotto.step2.domain;

import lotto.step2.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또는 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void lotto_숫자6개구성(int[] input, int[] expected) {
        Set<Integer> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toSet()));
        Set<Integer> expectedSet = new TreeSet<>(Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toSet()));

        Lotto lotto = Lotto.of(lottoSet);
        assertThat(lotto).isEqualTo(Lotto.of(expectedSet));
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

        Set<Integer> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toSet()));

        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.of(lottoSet);
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
}
