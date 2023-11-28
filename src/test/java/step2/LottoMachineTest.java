package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoMachine;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.strategy.LottoNumberRandomGenerator;

class LottoMachineTest {

    @Test
    @DisplayName("랜덤 번호의 로또가 구입 금액 만큼의 갯수로 생성된다")
    void lottoMachineTest() {
        int inputMoney = 10000;
        LottoPurchase lottoPurchase = new LottoPurchase(inputMoney);
        LottoMachine lottoMachine = new LottoMachine(lottoPurchase);
        assertThat(lottoMachine.getLottoPurchase().getLottoTicketCount().getRandomLottoTicketCount()).isEqualTo(10);
        assertThat(lottoMachine.getUserPurchaseLottos().getLottos()).hasSize(10);
    }

}
