package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCreateServiceTest {
    @Test
    void 자동생성된_로또_갯수_테스트() {
        LottoTicketAutoCreateStrategy autoLotteryService = new LottoTicketAutoCreateStrategy();
        assertThat(autoLotteryService.getLottoNumbers().size()).isEqualTo(6);
    }
}
