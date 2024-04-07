package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosBundleTest {

    @Test
    void merge() {
        LottosBundle lottosBundleOne = LottosBundle.fromNumbers(
                List.of(
                        Numbers.fromIntegers(List.of(8, 21, 23, 41, 42, 43)),
                        Numbers.fromIntegers(List.of(3, 5, 11, 16, 32, 38))
                ));

        LottosBundle lottosBundleTwo = LottosBundle.fromNumbers(List.of(
                Numbers.fromIntegers(List.of(1, 8, 11, 31, 41, 42)),
                Numbers.fromIntegers(List.of(7, 11, 30, 40, 42, 43)),
                Numbers.fromIntegers(List.of(2, 13, 22, 32, 38, 45))
        ));
        int expected = 5;

        assertThat(lottosBundleOne.merge(lottosBundleTwo).size()).isEqualTo(expected);
    }

    @Test
    void 수익률() {
        WinningLottos winnerLotto = WinningLottos.of(Numbers.fromIntegers(List.of(1,2,3,4,5,6)), Number.from(42));
        List<Numbers> numbers = List.of(
                Numbers.fromIntegers(List.of(8, 21, 23, 41, 42, 43)),
                Numbers.fromIntegers(List.of(3, 5, 11, 16, 32, 38)),
                Numbers.fromIntegers(List.of(7, 11, 16, 35, 36, 44)),
                Numbers.fromIntegers(List.of(13, 14, 16, 38, 42, 45)),
                Numbers.fromIntegers(List.of(1, 8, 11, 31, 41, 42)),
                Numbers.fromIntegers(List.of(7, 11, 30, 40, 42, 43)),
                Numbers.fromIntegers(List.of(2, 13, 22, 32, 38, 45)),
                Numbers.fromIntegers(List.of(1, 3, 5, 14, 22, 45)),
                Numbers.fromIntegers(List.of(2, 8, 9, 18, 19, 21)),
                Numbers.fromIntegers(List.of(23, 25, 33, 36, 39, 41)),
                Numbers.fromIntegers(List.of(5, 9, 38, 41, 43, 44)),
                Numbers.fromIntegers(List.of(13, 14, 18, 21, 23, 35)),
                Numbers.fromIntegers(List.of(17, 21, 29, 37, 42, 45)),
                Numbers.fromIntegers(List.of(3, 8, 27, 30, 35, 44))
        );
        LottosBundle lottosBundle = LottosBundle.fromNumbers(numbers);

        double expected = 0.35;

        assertThat(lottosBundle.calculateReturnOfRate(winnerLotto).toTwoDecimal()).isEqualTo(expected);
    }
}