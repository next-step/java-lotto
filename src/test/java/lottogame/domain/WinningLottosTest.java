package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottosTest {

    @Test
    void 생성() {
        WinningLottos winningLotto = LottoFactory.createWinningLotto(List.of(1, 2, 3, 4, 5, 6),  7);
        int expected = 6;

        assertThat(winningLotto.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("lottoAndRank")
    void 로또_당첨(Lottos lottos, Rank rank) {
        WinningLottos winnerLotto = new WinningLottos(List.of(1, 4, 5, 6, 7, 8), 9);
        System.out.println("winnerLotto.getRank(lottos) = " + winnerLotto.checkRank(lottos));
        assertThat(winnerLotto.checkRank(lottos)).isEqualTo(rank);
    }

    @ParameterizedTest
    @MethodSource("lottoAndPrize")
    void 로또_당첨_금액(Lottos lottos, Number prize) {
        WinningLottos winnerLotto = new WinningLottos(List.of(1, 4, 5, 6, 7, 8), 9);
        assertThat(winnerLotto.checkPrize(lottos)).isEqualTo(prize);
    }

    static Stream<Arguments> lottoAndRank() {
        return Stream.of(
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), Rank.FIRST),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 9)), Rank.SECOND),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 17)), Rank.THIRD),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 17, 21)), Rank.FOURTH),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 14, 17, 21)), Rank.FIFTH)
        );
    }

    static Stream<Arguments> lottoAndPrize() {
        return Stream.of(
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 8)), Number.from(2_000_000_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 9)), Number.from(30_000_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 7, 14)), Number.from(1_500_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 6, 14, 17)), Number.from(50_000)),
                Arguments.arguments(new Lottos(List.of(1, 4, 5, 14, 17, 21)), Number.from(5_000))
        );
    }

}
