package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:true", "999:false", "14001:true"}, delimiter = ':')
    void 로또를_구매한다(int givenMoney, boolean expected) {
        Buyer buyer = new Buyer();
        buyer.purchase(givenMoney);
        buyer.confirm();
        assertThat(buyer.hasLotto()).isEqualTo(expected);
    }
}
