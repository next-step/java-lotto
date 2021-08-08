package lotto;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketTest {
    private static final int GAME_COUNT = 10;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    LottoTicket lottoTicket = new LottoTicket();

    @Test
    void 게임수_만큼_로또번호_자동생성() {
        lottoTicket.generateNumbers(GAME_COUNT);
        assertThat(lottoTicket.getTicketInfo().size()).isEqualTo(10);
    }
}
