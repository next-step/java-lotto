package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    @ParameterizedTest(name = "[{index}] {0}원 투입")
    @ValueSource(ints = {1000, 5000, 18000, 330000})
    void 구입금액입력(int inputMoney) {
        Purchase purchase = new Purchase(inputMoney);
        assertThat(purchase.money()).isEqualTo(inputMoney);
    }

    @ParameterizedTest(name = "[{index}] {0}원 투입")
    @ValueSource(ints = {-1, -500, -3000, -15000})
    void 구입금액0미만입력(int inputMoney) {
        assertThatThrownBy(() -> new Purchase(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "구입 금액 {0}원 => 로또 {1}개 구매")
    @CsvSource(value = {"0:0", "1000:1", "15000:15", "21000:21"}, delimiter = ':')
    void 로또구매개수(int inputMoney, int expectedCount) {
        Purchase purchase = new Purchase(inputMoney);
        assertThat(purchase.count()).isEqualTo(expectedCount);
    }
}