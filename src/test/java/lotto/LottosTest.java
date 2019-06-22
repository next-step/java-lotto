package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}