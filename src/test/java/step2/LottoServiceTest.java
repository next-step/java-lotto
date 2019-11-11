package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.serivce.LottoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 500원 구매")
    @Test
    void buyLottoUnder1000Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoService.buyTickets(500);
        });
    }

    @DisplayName("로또 1500원 구매")
    @Test
    void buyLotto1500Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoService.buyTickets(1500);
        });
    }


    @DisplayName("로또 구매")
    @Test
    void buyLottoTest() {
        assertThat(lottoService.buyTickets(14000).getLottoTickets()).hasSize(14);
    }

    @DisplayName("로또 구매 실패")
    @Test
    void failBuyLottoTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoService.buyTickets(0);
        });
    }

    @DisplayName("로또 생성")
    @Test
    void generateAutoLottoTest() {
        assertThat(lottoService.getLottoTickets(3).getLottoTickets()).hasSize(3);
    }
}
