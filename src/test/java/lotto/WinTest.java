package lotto;

import lotto.domain.Win;
import lotto.enums.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinTest {
    Win win = new Win(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST_PLACE),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 9)), Rank.SECOND_PLACE),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 8, 9)), Rank.THIRD_PLACE),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 10, 8, 9)), Rank.FOURTH_PLACE),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.BONUS_PLACE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 당첨확인_테스트(Set<Integer> lottoNumbers, Rank rank) {
        assertThat(win.getRank(lottoNumbers)).isEqualTo(rank);
    }
}
