package step4.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.lotto.exception.LottoMachineNotEnoughMoneyException;
import step4.lotto.exception.LottoNumberInvalidFormatException;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("로또 자동 구입 테스트")
    void givenPurchaseAmount_whenBuyLotto_thenSuccess() {
        // given
        String purchaseAmount = "1234";

        // when
        LottoTicketList lottoTickets = lottoMachine.buyLottoTickets(new Money(purchaseAmount));

        // then
        assertThat(lottoTickets.value().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수동 구입 돈부족 테스트")
    void givenPurchaseAmountAndManualLottoCount_whenBuyLotto_thenSuccess() {
        // given
        String purchaseAmount = "1234";
        String manualLottoCount = "2";

        // when
        assertThatThrownBy(() -> lottoMachine.buyLottoTickets(new Money(purchaseAmount), new Count(manualLottoCount)))

            // then
            .isExactlyInstanceOf(LottoMachineNotEnoughMoneyException.class);
    }

    @Test
    @DisplayName("로또 자동 발행 테스트")
    void givenLottoMachine_whenCreateLottoMachine_thenSuccess() {
        // given && when
        LottoTicket lottoTicket = lottoMachine.issueLottoTicketAuto();

        // then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.value().size()).isEqualTo(6);
        for (LottoNumber lottoNumber : lottoTicket.value()) {
            assertThat(lottoNumber.value()).isBetween(1, 45);
        }
    }

}
