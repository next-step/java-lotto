package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class LottosTest {

    private static final Lotto WINNING_LOTTO =
            new Lotto(List.of(1, 2, 3, 4, 5, 6));

    private static final int BONUS_NUMBER = 7;


    @DisplayName("로또 묶음 수익율 계산 1번")
    @Test
    void earningRate_1() {
        Lotto zeroMatchLotto = new Lotto(List.of(31, 32, 33, 34, 35, 36));
        Lotto threeMatchLotto = new Lotto(List.of(1, 2, 3, 31, 32, 33));
        Lotto fourMatchLotto = new Lotto(List.of(1, 2, 3, 4, 31, 32));
        Lottos lottos = new Lottos(List.of(zeroMatchLotto, threeMatchLotto, fourMatchLotto));

        // (0 + 5000 + 50000) / (3 * 1000) = 18.33333..
        assertThat(lottos.earningRate(WINNING_LOTTO, BONUS_NUMBER))
                .isEqualTo(18.33, withPrecision(0.01));
    }

    @DisplayName("로또 묶음 수익율 계산 2번")
    @Test
    void earningRate_2() {
        Lotto fiveMatchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 31));
        Lotto bonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, BONUS_NUMBER));
        Lotto sixMatchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(fiveMatchLotto, bonusLotto, sixMatchLotto));

        // (150만 + 3천만 + 20억) / (3 * 1000) = 677166.6666...
        assertThat(lottos.earningRate(WINNING_LOTTO, BONUS_NUMBER))
                .isEqualTo(677166.66, withPrecision(0.01));
    }

}
