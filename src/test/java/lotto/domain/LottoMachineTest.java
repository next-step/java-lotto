package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 구매")
    @ParameterizedTest
    @CsvSource(value = {
            "14000=14",
            "1000=1",
            "1001=1",
            "1999=1"
    }, delimiter = '=')
    void purchaseCountTest(int input, int expected) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(input);

        Lottos lottos = lottoMachine.purchase(purchaseMoney);

        assertThat(lottos.getCount()).isEqualTo(expected);
    }

}