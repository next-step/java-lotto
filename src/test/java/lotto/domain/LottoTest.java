package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("중복되지 않은 숫자 6개로 Lotto 생성하는데 성공")
    @ParameterizedTest
    @MethodSource("source_create_notDuplicatedNumbers_shouldSucceed")
    public void create_notDuplicatedNumbers_shouldSucceed(List<Integer> param, Lotto expected) {
        Lotto result = Lotto.generateByManual(param);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_create_notDuplicatedNumbers_shouldSucceed() {
        return Stream.of(
                Arguments.of(Arrays.asList(new int[]{1, 2, 3, 4, 5, 6}), Lotto.generateByManual(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}))),
                Arguments.of(Arrays.asList(new int[]{40, 41, 42, 43, 44, 45}), Lotto.generateByManual(Arrays.asList(new Integer[]{40, 41, 42, 43, 44, 45}))));
    }

    @DisplayName("중복된 숫자 6개로 Lotto 생성 시에 throws IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("source_create_duplicatedNumbers_shouldFail")
    public void create_source_create_duplicatedNumbers_shouldFail(List<Integer> param) {
        assertThatThrownBy(() -> {
            Lotto.generateByManual(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_create_duplicatedNumbers_shouldFail() {
        return Stream.of(
                Arguments.of(Arrays.asList(new int[]{1, 1, 3, 4, 5, 6})),
                Arguments.of(Arrays.asList(new int[]{40, 41, 42, 43, 45, 45})));
    }
}
