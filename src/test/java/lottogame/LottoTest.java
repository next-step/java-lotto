package lottogame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lottogame.domain.Lotto;
import lottogame.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @ParameterizedTest
    @MethodSource("lottoAndRank")
    void 로또_당첨(Lotto winnerLotto, Lotto lotto, Rank rank) {
        assertThat(winnerLotto.getRank(lotto)).isEqualTo(rank);
    }

    @ParameterizedTest
    @MethodSource("lottoAndPrize")
    void 로또_당첨_금액(Lotto winnerLotto, Lotto lotto, int prize) {
        assertThat(winnerLotto.getPrize(lotto)).isEqualTo(prize);
    }

    static Stream<Arguments> lottoAndRank() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 8)),
                        Rank.FIRST),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 14)),
                        Rank.SECOND),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 14, 17)),
                        Rank.THIRD),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 14, 17, 21)),
                        Rank.FOURTH)
        );
    }

    static Stream<Arguments> lottoAndPrize() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 8)), 2_000_000_000),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 7, 14)), 1_500_000),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 6, 14, 17)), 50_000),
                Arguments.arguments(new Lotto(List.of(1, 4, 5, 6, 7, 8)), new Lotto(List.of(1, 4, 5, 14, 17, 21)), 5_000)
        );
    }
}