package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @DisplayName("구매금액(cash)에 따라서 몇 번의 구매인지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4"}, delimiter = ':')
    void purchaseAmount_happyCase(int cash, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        assertThat(purchaseAmount.purchases()).isEqualTo(expected);
    }

    @DisplayName("구매금액(cash)이 1000원 단위가 아닐때 - 구매가능한 수량만큼 구매")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1500:1", "2500:2", "999:0"}, delimiter = ':')
    void purchaseAmount_blueCase(int cash, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        assertThat(purchaseAmount.purchases()).isEqualTo(expected);
    }
}
