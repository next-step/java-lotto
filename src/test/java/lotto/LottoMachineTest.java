package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("구입 금액으로 살 수 있는 만큼 로또를 발급한다")
    @ParameterizedTest(name = "{0}원이면 {1}장")
    @CsvSource({"1000, 1", "14000, 14", "14500, 14"})
    void purchaseLotto(int money, int count) {
        LottoMachine machine = new LottoMachine(money);

        assertThat(machine.getLottos()).hasSize(count);
    }

    @DisplayName("1000원 미만은 로또를 살 수 없다")
    @Test
    void cannotPurchaseLottoWhenMoneyUnder1000() {
        assertThatThrownBy(() -> new LottoMachine(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
