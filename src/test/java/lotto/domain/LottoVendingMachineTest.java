package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoVendingMachineTest {

    @DisplayName("로또의 가격은 1장당 1,000원이며 여러 개를 한 번에 구입할 수 있음")
    @ValueSource(ints = {1000, 2000, 3000, 5000, 10000, 20000, 25000})
    @ParameterizedTest
    void buyLottosTest(int amount) {

        List<Lotto> lottos = LottoVendingMachine.defaultVendingMachine()
                                                .buyLottos(Money.of(amount));

        int expected = amount / 1000;
        assertEquals(expected, lottos.size());
    }
}
