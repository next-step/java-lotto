package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoAmountTest {
    @Test
    @DisplayName("로또 구매 최소금액 예외처리")
    void leastMoneyOfLotto() {
        assertThatThrownBy(() -> new LottoAmount(800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("금액에 따라 로또 개수 확인")
    @CsvSource(value = {
            "1000:1",
            "10000:10",
            "2000:2",
            "3200:3"
    }, delimiter = ':')
    void checkLottoAmount(int money, int amount) {
        assertThat(new LottoAmount(money).amountOfLottos()).isEqualTo(amount);
    }

    @Test
    @DisplayName("수동 로또가 총 구매개수 초과시 예외")
    void checkManualAmount() {
        LottoAmount lottoAmount = new LottoAmount(10000);

        assertThatThrownBy(() -> lottoAmount.checkManualAmount(11))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
