package lotto;

import lotto.domain.Match;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class MatchTest {

    @ParameterizedTest
    @NullSource
    void if_null(List<Integer> nullList) {
        assertThatThrownBy(() -> {
            Match.getCount(List.of(1,2,3), nullList);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Match.getCount(nullList, List.of(1,2,3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("passInputListAndResult")
    void if_not_null(List<Integer> sources, List<Integer> targets, int result){
        int matchCount = Match.getCount(sources, targets);
        assertThat(matchCount).isEqualTo(result);
    }

    private static Stream<Arguments> passInputListAndResult(){
        return Stream.of(
            Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
            Arguments.of(List.of(1, 0, 4), List.of(1, 2, 3), 1),
            Arguments.of(List.of(1), List.of(1, 2, 3, 4), 1),
            Arguments.of(List.of(4, 3), List.of(1, 2, 3, 4), 2)
        );
    }
}
