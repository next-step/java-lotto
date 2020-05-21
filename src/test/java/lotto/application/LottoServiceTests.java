package lotto.application;

import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTests {
    private LottoService lottoService;

    @BeforeEach
    public void setup() {
        lottoService = new LottoService();
    }

    @DisplayName("돈을 입력받아서 자동으로 로또를 구매한 뒤 LottoTickets를 반환")
    @Test
    void buyLottoTest() {
        LottoTickets lottoTickets = lottoService.buyLottoTickets(10000);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}
