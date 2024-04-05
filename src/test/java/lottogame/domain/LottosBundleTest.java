package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
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
    void 로또_총_구매_금액() {
        LottosBundle lottosBundle = LottosBundle.fromNumbers(
                List.of(
                    Numbers.fromIntegers(List.of(8, 21, 23, 41, 42, 43)),
                    Numbers.fromIntegers(List.of(3, 5, 11, 16, 32, 38))
                ));
        Money lottoPrice = Money.from(1000);
        Money expected = Money.from(2000);

        assertThat(lottosBundle.calculatePurchaseAmount(lottoPrice)).isEqualTo(expected);
    }

    @Test
    void 로또_총_수익() {
        LottosBundle lottosBundle = LottosBundle.fromNumbers(
                List.of(
                        Numbers.fromIntegers(List.of(1,2,3,4,5,7)),
                        Numbers.fromIntegers(List.of(1,2,3,4,7,8))
                ));
        Money expected = Money.from(30_050_000);
        WinningLottos winningLottos = LottoFactory.createWinningLotto(
                Numbers.fromIntegers(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertThat(lottosBundle.calculateSumOfPrize(winningLottos)).isEqualTo(expected);
    }
}