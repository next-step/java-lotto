package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.serivce.LottoService;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 구매")
    @Test
    void buyLottoTest() {
        assertThat(lottoService.buyTickets(14000).getLottoTickets()).hasSize(14);
    }

    @DisplayName("로또 생성")
    @Test
    void generateAutoLottoTest() {
        assertThat(lottoService.getLottoTickets(3).getLottoTickets()).hasSize(3);
    }
}
