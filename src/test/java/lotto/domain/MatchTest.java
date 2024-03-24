package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatchTest {

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

    @ParameterizedTest
    @DisplayName("2 개의 배열 중에 하나라도 null이면 예외")
    @NullSource
    void if_null(List<Integer> nullList) {
        assertThatThrownBy(() -> {
            Match.getCount(List.of(1, 2, 3), nullList);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Match.getCount(nullList, List.of(1, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("두 개의 배열을 비교하여 일치하는 개수 반환((1,2,3],[1,2,3]) => 3, ([1,0,4],[1,2,3]) => 1, ([1],[1,2,3,4]) =>1, ([4,3],[1,2,3,4]) => 2")
    @MethodSource("passInputListAndResult")
    void if_not_null(List<Integer> sources, List<Integer> targets, int result) {
        int matchCount = Match.getCount(sources, targets);
        assertThat(matchCount).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 있는지 확인(([1,2,3], 2) => true, ([1,2,3], 5) => false")
    @MethodSource("bonusInputAndResult")
    void if_bonus(List<Integer> source, int bonusNumber, boolean result){
        boolean isBonusContain = Match.getCount(source, bonusNumber);
        assertThat(isBonusContain).isEqualTo(result);
    }
}
