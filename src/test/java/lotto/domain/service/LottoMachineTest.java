package lotto.domain.lotto;

import lotto.service.LottoMachine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {


    @ParameterizedTest
    @CsvSource(value = {"14000, 14", "5000, 5"})
    void 로또를_구입금액에_맞게_생성한다(int purchaseAmount, int quantity) {
        LottoMachine lottoMachine = LottoMachine.turnOn();
        LottoTicket lottoTicket = lottoMachine.purchaseLotto(purchaseAmount);
        assertThat(lottoTicket.getLottoTicket()).size().isEqualTo(quantity);
    }

}