package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchasesTest {

    @ValueSource(ints = {4000})
    @ParameterizedTest
    void 금액에_따른_로또횟수_확인(int ints) {
        final LottoPurchases lottoPurchases = new LottoPurchases(ints);
        assertThat(lottoPurchases.getLottoMachineCount()).isEqualTo(4);
    }

    @ValueSource(ints = {900})
    @ParameterizedTest
    void 로또_금액을_확인(int ints) {
        final LottoPurchases lottoPurchases = new LottoPurchases(ints);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoPurchases.getLottoMachineCount());
    }
}