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
        Numbers numbers = Numbers.fromIntegers(List.of(1,2,3,4,5,6));
        WinningLottos winningLotto = LottoFactory.createWinningLotto(numbers,  7);
        int expected = 6;

        assertThat(winningLotto.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("lottoAndRank")
    void 로또_당첨(Lottos lottos, Rank rank) {
        Numbers numbers = Numbers.fromIntegers(List.of(1,4,5,6,7,8));
        WinningLottos winnerLotto = new WinningLottos(numbers, 9);
        System.out.println("winnerLotto.getRank(lottos) = " + winnerLotto.checkRank(lottos));
        assertThat(winnerLotto.checkRank(lottos)).isEqualTo(rank);
    }

    @ParameterizedTest
    @MethodSource("lottoAndPrize")
    void 로또_당첨_금액(Lottos lottos, Number prize) {
        Numbers numbers = Numbers.fromIntegers(List.of(1,4,5,6,7,8));
        WinningLottos winnerLotto = new WinningLottos(numbers, 9);
        assertThat(winnerLotto.calculatePrize(lottos)).isEqualTo(prize);
    }

    static Stream<Arguments> lottoAndRank() {
        return Stream.of(
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 8))), Rank.FIRST),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 9))), Rank.SECOND),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 17))), Rank.THIRD),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 17, 21))), Rank.FOURTH),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 14, 17, 21))), Rank.FIFTH)
        );
    }

    static Stream<Arguments> lottoAndPrize() {
        return Stream.of(
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 8))), Number.from(2_000_000_000)),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 9))), Number.from(30_000_000)),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 7, 17))), Number.from(1_500_000)),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 6, 17, 21))), Number.from(50_000)),
                Arguments.arguments(Lottos.from(Numbers.fromIntegers(List.of(1, 4, 5, 14, 17, 21))), Number.from(5_000))
        );
    }
}
