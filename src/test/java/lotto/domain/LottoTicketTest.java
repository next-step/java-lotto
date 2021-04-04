package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 생성")
    public void create() throws Exception {
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        LottoTicket lottoTicket = new LottoTicket(LottoNumbers.from(lottoNumbers));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(LottoNumbers.from(lottoNumbers)));
    }
}
