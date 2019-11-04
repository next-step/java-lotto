package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoService;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void buyLottoTest() {
        assertThat(lottoService.buyTickets(14000)).isEqualTo(14);
    }

    @Test
    void generateAutoLottoTest() {
        assertThat(lottoService.generateAutoLotto(3)).hasSize(3);
    }

    @Test
    void getWinnerTest() {

    }
}
