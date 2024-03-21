package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class AmountTest {
    @Test
    void 구입금액_생성() {
        Amount amount = new Amount("14000");
        assertThat(amount.value()).isEqualTo(14000);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "0", "1000.5", "900", "-2000", "삼천원"})
    void 적절하지_않은_구입금액(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(input));
    }
}
