package lotto;

import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    public void 구매가능한_로또개수() {
        assertThat(lottoService.calculateLottoCount(14400))
                .isEqualTo(14);
    }

}
