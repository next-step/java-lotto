package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {


    @Test
    @DisplayName("로또 티켓을 구매금액/로또가격 개수만큼 구매했는지 테스트")
    void addLottoTicket() {
        //given
        LottoTickets lottoTickets = new LottoTickets();

        //when
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        //then
        assertThat(lottoTickets.getLottos().size()).isEqualTo(2);
    }


}