package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.serivce.LottoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoServiceTest {
    @DisplayName("로또 500원 구매")
    @Test
    void buyLottoUnder1000Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoService.buyTickets(500);
        });
    }

    @DisplayName("로또 1500원 구매")
    @Test
    void buyLotto1500Test() {
        assertThat(LottoService.buyTickets(1500).getLottoTickets()).hasSize(1);
    }


    @DisplayName("로또 구매")
    @Test
    void buyLottoTest() {
        assertThat(LottoService.buyTickets(14000).getLottoTickets()).hasSize(14);
    }

    @DisplayName("로또 구매 실패")
    @Test
    void failBuyLottoTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoService.buyTickets(0);
        });
    }
}
