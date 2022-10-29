package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    @DisplayName("구입한 로또의 개수만큼 입력하면 로또의 개수는 그만큼 만들어진다.")
    void inputLottoTicketCountTest() {
        List<String> manualLottos = List.of("1,2,3,4,5,6", "2,4,6,8,10,12");
        LottoCount lottoCount = new LottoCount(5);
        LottoTicket lottoTicket = new LottoTicket(lottoCount, manualLottos);

        assertThat(lottoTicket.getLottos()).hasSize(5);
    }
}
