package step3.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("로또 구입 테스트")
    void givenPurchaseAmount_whenBuyLotto_thenSuccess() {
        // given
        String purchaseAmount = "1234";

        // when
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets(new Money(purchaseAmount));

        // then
        assertThat(lottoTickets.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 발행 테스트")
    void givenLottoMachine_whenCreateLottoMachine_thenSuccess() {
        // given && when
        LottoTicket lottoTicket = lottoMachine.issueLottoTicket();

        // then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.value().size()).isEqualTo(6);
        for (LottoNumber lottoNumber : lottoTicket.value()) {
            assertThat(lottoNumber.value()).isBetween(1, 45);
        }
    }

}
