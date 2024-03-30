package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottosTest {

    private static Stream<Arguments> passInputListAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 0, 4), List.of(1, 2, 3), 1),
                Arguments.of(List.of(1), List.of(1, 2, 3, 4), 1),
                Arguments.of(List.of(4, 3), List.of(1, 2, 3, 4), 2)
        );
    }

    private static Stream<Arguments> bonusInputAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, true),
                Arguments.of(List.of(1, 2, 3), 5, false)
        );
    }

    @Test
    @DisplayName("winningNumber 또는 bonusNumber가 null이면 예외((null, 0) => IllegalArgumentException, (0, null) => IllegalArgumentException)")
    void validate_if_not_null() {
        assertThatThrownBy(() -> {
            new WinningLotto(null, 1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자가 로또 넘버 안에 포함되면 예외(([1,2,3,4], 1) => IllegalArgumentException)")
    void bonus_number_should_not_be_in_lotto_numbers() {
        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3), 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("두 개의 배열을 비교하여 일치하는 개수 반환((1,2,3],[1,2,3]) => 3, ([1,0,4],[1,2,3]) => 1, ([1],[1,2,3,4]) =>1, ([4,3],[1,2,3,4]) => 2")
    @MethodSource("passInputListAndResult")
    void if_not_null(List<Integer> sources, List<Integer> targets, int result) {
        int matchCount = new WinningLotto(targets).getMatchCount(new LottoNumber(sources));
        assertThat(matchCount).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 있는지 확인(([1,2,3], 2) => true, ([1,2,3], 5) => false")
    @MethodSource("bonusInputAndResult")
    void if_bonus(List<Integer> sources, int bonusNumber, boolean result) {
        boolean isBonusContain = new WinningLotto(bonusNumber).isBonusContains(new LottoNumber(sources));
        assertThat(isBonusContain).isEqualTo(result);
    }
}
