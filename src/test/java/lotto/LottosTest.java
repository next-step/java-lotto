package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static lotto.Lottos.AMOUNT_PER_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottosTest {

    @Test
    void getLottoCount() {

        int purchaseAmount = 14000;
        Lottos lottos = new Lottos(purchaseAmount);
        assertThat(lottos.getLottoCount()).isEqualTo(purchaseAmount / AMOUNT_PER_LOTTO);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void getLottosCountIsLowerEqualsThan0(int purchaseAmount) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottos(purchaseAmount));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void getLastWeekNumbersCorrectCount(int correctCount) {

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 12, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        ));

        LastWeekNumbers lastWeekNumbers = new LastWeekNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottos.getLastWeekNumbersCorrectCount(correctCount, lastWeekNumbers)).isEqualTo(1);
    }
}