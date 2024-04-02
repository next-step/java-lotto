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
        WinningLottos winnerLotto = new WinningLottos(List.of(Number.from(1), Number.from(2),
                Number.from(3), Number.from(4), Number.from(5),Number.from(6)), 42);
        List<Lottos> lottos = List.of(
                new Lottos(List.of(Number.from(8), Number.from(21), Number.from(23), Number.from(41), Number.from(42), Number.from(43))),
                new Lottos(List.of(Number.from(3), Number.from(5), Number.from(11), Number.from(16), Number.from(32), Number.from(38))),
                new Lottos(List.of(Number.from(7), Number.from(11), Number.from(16), Number.from(35), Number.from(36), Number.from(44))),
                new Lottos(List.of(Number.from(13), Number.from(14), Number.from(16), Number.from(38), Number.from(42), Number.from(45))),
                new Lottos(List.of(Number.from(1), Number.from(8), Number.from(11), Number.from(31), Number.from(41), Number.from(42))),
                new Lottos(List.of(Number.from(7), Number.from(11), Number.from(30), Number.from(40), Number.from(42), Number.from(43))),
                new Lottos(List.of(Number.from(2), Number.from(13), Number.from(22), Number.from(32), Number.from(38), Number.from(45))),
                new Lottos(List.of(Number.from(1), Number.from(3), Number.from(5), Number.from(14), Number.from(22), Number.from(45))),
                new Lottos(List.of(Number.from(2), Number.from(8), Number.from(9), Number.from(18), Number.from(19), Number.from(21))),
                new Lottos(List.of(Number.from(23), Number.from(25), Number.from(33), Number.from(36), Number.from(39), Number.from(41))),
                new Lottos(List.of(Number.from(5), Number.from(9), Number.from(38), Number.from(41), Number.from(43), Number.from(44))),
                new Lottos(List.of(Number.from(13), Number.from(14), Number.from(18), Number.from(21), Number.from(23), Number.from(35))),
                new Lottos(List.of(Number.from(17), Number.from(21), Number.from(29), Number.from(37), Number.from(42), Number.from(45))),
                new Lottos(List.of(Number.from(3), Number.from(8), Number.from(27), Number.from(30), Number.from(35), Number.from(44)))
        );
        double expected = 0.35;

        assertThat(lottoGame.calculateReturnOfRate(winnerLotto, lottos).toTwoDecimal()).isEqualTo(expected);
    }

    @Test
    void merge() {
        List<Lottos> multipleLottosOne = List.of(
                new Lottos(List.of(Number.from(8), Number.from(21), Number.from(23), Number.from(41), Number.from(42), Number.from(43))),
                new Lottos(List.of(Number.from(3), Number.from(5), Number.from(11), Number.from(16), Number.from(32), Number.from(38)))
        );

        List<Lottos> multipleLottosTwo = List.of(
                new Lottos(List.of(Number.from(1), Number.from(8), Number.from(11), Number.from(31), Number.from(41), Number.from(42))),
                new Lottos(List.of(Number.from(7), Number.from(11), Number.from(30), Number.from(40), Number.from(42), Number.from(43))),
                new Lottos(List.of(Number.from(2), Number.from(13), Number.from(22), Number.from(32), Number.from(38), Number.from(45)))
        );
        int expected = 5;

        assertThat(lottoGame.merge(multipleLottosOne, multipleLottosTwo).size()).isEqualTo(expected);
    }
}