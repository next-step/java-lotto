package step3.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoVendingMachineTest {

    @DisplayName("금액은 1,000원 단위로 입력해야 함")
    @ValueSource(ints = {500, 1500, 2200, 12345})
    @ParameterizedTest
    void moneyTest(int money) {
        Assertions.assertThatIllegalArgumentException()
                  .isThrownBy(() -> LottoVendingMachine.getInstance().buyLottos(money));
    }

    @DisplayName("로또의 가격은 1장당 1,000원이며 여러 개를 한 번에 구입할 수 있음")
    @ValueSource(ints = {1000, 2000, 3000, 5000, 10000, 20000, 25000})
    @ParameterizedTest
    void buyLottosTest(int money) {
        List<Lotto> lottos = LottoVendingMachine.getInstance().buyLottos(money);
        int expected = money / 1000;
        assertEquals(expected, lottos.size());
    }
}
