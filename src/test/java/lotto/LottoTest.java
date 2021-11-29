package lotto;

import org.junit.jupiter.api.DisplayName;
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

    @ParameterizedTest
    @MethodSource("matchCountSource")
    @DisplayName("Lotto 는 Lotto 와 협력하여 일반 번호 중 몇개가 match 되는지 구할 수 있다.")
    void matchCount(List<Integer> winNumbers, int result) {
        // given
        Lotto self = new Lotto(1, 2, 3, 4, 5, 6);

        // when
        Lotto other = new Lotto(winNumbers);

        // then
        assertThat(self.matchCount(other)).isEqualTo(result);
    }

    static Stream<Arguments> matchCountSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(Arrays.asList(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(Arrays.asList(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(Arrays.asList(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(Arrays.asList(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("bonusContainedSource")
    @DisplayName("Lotto 는 WinLotto 와 협력하여 보너스 번호가 match 되는지 확인 할 수 있다.")
    void bonusContained(List<Integer> myNumber, int bonusNumber, boolean result) {
        // given
        Lotto self = new Lotto(myNumber);

        // when
        LottoNumber lottoNumber = LottoNumber.of(bonusNumber);

        // then
        assertThat(self.contains(lottoNumber)).isEqualTo(result);
    }

    static Stream<Arguments> bonusContainedSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, false),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 7), 7, true)
        );
    }
}
