package lottoTest;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket ticket = new LottoTicket();

    @DisplayName("로또 번호를 자동으로 생성한다 - 중복 없는지 체크")
    @Test
    public void isItDuplication() {
        List<Integer> lotto1 = ticket.buyTicket();
        List<Integer> lotto2 = ticket.buyTicket();

        assertThat(lotto1.size()).isEqualTo(6);
        assertThat(lotto2.size()).isEqualTo(6);
        assertThat(lotto1).isNotEqualTo(lotto2);
    }
}
