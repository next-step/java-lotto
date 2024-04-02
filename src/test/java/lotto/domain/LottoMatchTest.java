package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    private static final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final int bonusNumber = 7;

    @DisplayName("Lotto와 WinningLotto를 제시했을 때 일치 수에 따라 그에 알맞은 Rank 반환")
    @ParameterizedTest
    @MethodSource("match")
    void findRank(Lotto lotto, WinningLotto winningLotto, Rank rank) {
        assertThat(LottoMatch.match(lotto, winningLotto)).isEqualTo(rank);
    }

    static Stream<Arguments> match() {
        return Stream.of(
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.FIRST),
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.SECOND),
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.THIRD),
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.FOURTH),
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.FIFTH),
                Arguments.arguments(new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11)),
                        new WinningLotto(winNumbers, bonusNumber), Rank.NONE)
        );
    }
}
