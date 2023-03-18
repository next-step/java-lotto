package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchasesTest {

    @Test
    void 금액_선택에_따라_수동_자동_횟수_확인() {
        final LottoPurchases lottoPurchases = new LottoPurchases(4000, 2);
        assertThat(lottoPurchases.getPassivityCount()).isEqualTo(2);
    }

    @ValueSource(ints = {900})
    @ParameterizedTest
    void 로또_금액은_1000원_미만일_수_없다(int ints) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoPurchases(ints, 0));
    }
}