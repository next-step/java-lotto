import static org.assertj.core.api.Assertions.assertThat;

import lotto.LottoService;
import lotto.LottoTicketBall;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private LottoService lottoService = new LottoService();

    @Test
    public void 구입금액에_따른_로또_발급() {
        assertThat(lottoService.purchaseLotto(14000).size()).isEqualTo(14);
    }

}

