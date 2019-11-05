package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoService;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 구매")
    @Test
    void buyLottoTest() {
        assertThat(lottoService.buyTickets(14000)).hasSize(14);
    }

    @DisplayName("로또 생성")
    @Test
    void generateAutoLottoTest() {
        assertThat(lottoService.generateAutoLotto(3)).hasSize(3);
    }
}
