package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입 금액에 해당하는만큼 로또 구매")
    @ParameterizedTest
    @CsvSource(value = {
            "14000=14",
            "1000=1",
            "1001=1",
            "1999=1"
    }, delimiter = '=')
    void purchaseCountTest(int input, int expected) {
        LottoMachine lottoMachine = new LottoMachine(new PurchaseMoney(input));

        Lottos lottos = lottoMachine.purchase();

        assertThat(lottos.getCount()).isEqualTo(expected);
    }
}
