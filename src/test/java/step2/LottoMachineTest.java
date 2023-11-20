package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoNumberRandomGenerator;

class LottoMachineTest {

    @Test
    @DisplayName("랜덤 번호의 로또가 구입 금액 만큼의 갯수로 생성된다")
    void lottoMachineTest() {
        int inputMoney = 10000;
        LottoMachine lottoMachine = new LottoMachine(inputMoney, new LottoNumberRandomGenerator());
        assertThat(lottoMachine.getLottoPurchaseInfo().getLottoTicketCount()).isEqualTo(10);
        assertThat(lottoMachine.getPurchaseLottos().getLottos()).hasSize(10);
    }


}