package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class LottoGameTest {
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    void 수익률() {
        WinningLottos winnerLotto = new WinningLottos(List.of(1, 2, 3, 4, 5, 6), 42);
        List<Lottos> lottos = List.of(
                new Lottos(List.of(8, 21, 23, 41, 42, 43)),
                new Lottos(List.of(3, 5, 11, 16, 32, 38)),
                new Lottos(List.of(7, 11, 16, 35, 36, 44)),
                new Lottos(List.of(13, 14, 16, 38, 42, 45)),
                new Lottos(List.of(1, 8, 11, 31, 41, 42)),
                new Lottos(List.of(7, 11, 30, 40, 42, 43)),
                new Lottos(List.of(2, 13, 22, 32, 38, 45)),
                new Lottos(List.of(1, 3, 5, 14, 22, 45)),
                new Lottos(List.of(2, 8, 9, 18, 19, 21)),
                new Lottos(List.of(23, 25, 33, 36, 39, 41)),
                new Lottos(List.of(5, 9, 38, 41, 43, 44)),
                new Lottos(List.of(13, 14, 18, 21, 23, 35)),
                new Lottos(List.of(17, 21, 29, 37, 42, 45)),
                new Lottos(List.of(3, 8, 27, 30, 35, 44))
        );
        double expected = 0.35;

        assertThat(lottoGame.calculateReturnOfRate(winnerLotto, lottos)).isEqualTo(expected);
    }

    @Test
    void merge() {
        List<Lottos> multipleLottosOne = List.of(
                new Lottos(List.of(8, 21, 23, 41, 42, 43)),
                new Lottos(List.of(3, 5, 11, 16, 32, 38))
        );

        List<Lottos> multipleLottosTwo = List.of(
                new Lottos(List.of(1, 8, 11, 31, 41, 42)),
                new Lottos(List.of(7, 11, 30, 40, 42, 43)),
                new Lottos(List.of(2, 13, 22, 32, 38, 45))
        );
        int expected = 5;

        assertThat(lottoGame.merge(multipleLottosOne, multipleLottosTwo).size()).isEqualTo(expected);
    }
}