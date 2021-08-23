package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구매금액(cash)에 따라서 몇 번의 구매인지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4"}, delimiter = ':')
    void purchaseAmount_happyCase(int cash, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        assertThat(purchaseAmount.purchases()).isEqualTo(expected);
    }

    @DisplayName("구매금액(cash)이 1000원 이하일 때 - 구매가능한 수량만큼 구매")
    @ParameterizedTest
    @ValueSource(ints = {0,999})
    void purchaseAmount_blueCase_minimumCondition(int cash) {
        assertThatThrownBy(() -> new PurchaseAmount(cash))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구매 금액이 1000원 입니다.(1장당 1000원)");
    }

    @DisplayName("구매금액(cash)이 1000원 단위가 아닐때 - 구매가능한 수량만큼 구매")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 9999})
    void purchaseAmount_blueCase_doesNotThousandUnit(int cash) {
        assertThatThrownBy(() -> new PurchaseAmount(cash))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매금액은 1000원 단위 입니다.");
    }
}
