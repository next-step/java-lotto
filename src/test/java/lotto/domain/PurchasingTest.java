package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasingTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "1001", "1999"})
    void 금액_로또_개수(String number) {
        assertThat(new Purchasing(new Money(number)).getLottoCount()).isEqualTo(1);
    }
}
