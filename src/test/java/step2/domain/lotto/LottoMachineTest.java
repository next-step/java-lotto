package step2.domain.lotto;

import org.junit.jupiter.api.Test;
import step2.domain.statistics.Amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @Test
    void createLottoMachineFailTest() {
        assertThatThrownBy(() -> new LottoMachine(new Price(14000), new Amount(15)))
                .isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    void createLottoMachineSuccessTest() {
        final LottoMachine lottoMachine = new LottoMachine(new Price(14000), new Amount(14));
        assertThat(lottoMachine).isEqualTo(new LottoMachine(new Price(14000), new Amount(14)));
    }
}