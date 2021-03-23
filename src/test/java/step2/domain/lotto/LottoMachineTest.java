package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Money;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6000:6",
            "5500:5",
            "14200:14"}, delimiter = ':')
    @DisplayName("살 수 있는 로또의 개수를 구할 수 있")
    void calculatesLottoCapacity(int wanted, int expected) {
        int capacity = lottoMachine.normalLottoCapacity(new Money(wanted));
        Assertions.assertThat(capacity).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6000:6",
            "5500:5",
            "14200:14"}, delimiter = ':')
    @DisplayName("원하는 수의 로또를 살 수 있다")
    void canBuyValidLottoSize(int wanted, int expected) {
        LottoList lottoList = lottoMachine.buyAutoLotto(new Money(wanted));
        Assertions.assertThat(lottoList.getLottoSize()).isEqualTo(expected);
    }

}
