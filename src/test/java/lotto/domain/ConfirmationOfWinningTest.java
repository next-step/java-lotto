package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmationOfWinningTest {

    @ParameterizedTest
    @MethodSource("provideLottoWithRankResult")
    void getRank_n개일치_m위(Lotto lotto, int rankResult) {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(rankResult);
    }

    static Stream<Arguments> provideLottoWithRankResult() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 1),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), 2),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), 4),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)), 5),
                Arguments.of(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)), 5),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), 5)
        );
    }
}
