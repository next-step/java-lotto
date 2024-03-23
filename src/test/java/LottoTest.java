import static org.assertj.core.api.Assertions.assertThat;

import lotto.LottoService;
import lotto.LottoTicketBall;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private LottoTicketBall ball = new LottoTicketBall();

    @Test
    public void 구입금액에_따른_로또_발급() {
        int count = LottoService.calculateLottoCount(14000);
        assertThat(count).isEqualTo(14);
    }

}

