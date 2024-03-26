package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @ParameterizedTest
    @MethodSource("lottoAndRank")
    void 로또_당첨(Lottos winnerLotto, Lottos lottos, Rank rank) {
        assertThat(winnerLotto.getRank(lottos)).isEqualTo(rank);
    }

    @ParameterizedTest
    @MethodSource("lottoAndPrize")
    void 로또_당첨_금액(Lottos winnerLotto, Lottos lottos, Number prize) {
        assertThat(winnerLotto.getPrize(lottos)).isEqualTo(prize);
    }

    static Stream<Arguments> lottoAndRank() {
        return Stream.of(
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 7, 8)),
                        Rank.FIRST),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 7, 14)),
                        Rank.SECOND),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 14, 17)),
                        Rank.THIRD),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 14, 17, 21)),
                        Rank.FOURTH)
        );
    }

    static Stream<Arguments> lottoAndPrize() {
        return Stream.of(
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 7, 8)), Number.from(2_000_000_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 7, 14)), Number.from(1_500_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 6, 14, 17)), Number.from(50_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), new Lottos(List.of(1, 4, 5, 14, 17, 21)), Number.from(5_000))
        );
    }
}