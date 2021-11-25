package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(List<Integer> lottoNumberList) {
        // given
        Lotto self = new Lotto(lottoNumberList);

        // when
        Lotto other = new Lotto(lottoNumberList);

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5, 6)) // 7개의 번호를 선택했지만 중복을 제거하면 6개의 번호가 되는 경우
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_createSource")
    void invalid_create(List<Integer> lottoNumberList) {
        // given
        assertThatThrownBy(() -> {
            new Lotto(lottoNumberList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)), // 5개의 번호만 고른 경우
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)), // 6개의 번호를 선택했지만 LottoNumber 가 될 수 없는 수가 있는 경우
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)) // 6개의 번호를 선택했지만 중복된 숫자가 있는 경우
        );
    }
}
