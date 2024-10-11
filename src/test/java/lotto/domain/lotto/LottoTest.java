package lotto.domain.lotto;

import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("")
    void 지난_주_당첨_번호_확인() {
        Lotto lotto = new Lotto(null, () -> new LottoTicket("1,2,3,4,5,6"));

        assertThat(lotto.getLastWeekWinningNumbers()).isEqualTo(new LottoTicket("1,2,3,4,5,6"));
    }

    @Test
    void 구매_로또_생성() {
        int purchaseNumber = 2;
        LottoTicket ticket = new LottoTicket("1,2,3,4,5,6");

        Lotto lotto = new Lotto(new LottoTickets(), () -> new LottoTicket("1,2,3,4,5,6"));

        assertThat(lotto.purchaseLotto(purchaseNumber)).isEqualTo(new LottoTickets(List.of(ticket, ticket)));
    }

    @Test
    void 당첨_금액_별_개수_계산() {
        Lotto lotto = new Lotto(new LottoTickets(new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,7")), () -> null);

        assertThat(lotto.getHitLottoNumbers(new LottoTicket(1, 2, 3, 4, 5, 6))).containsAllEntriesOf(Map.of(
                5, 1500000, // 1등이 1번 나와야 함
                6, 2000000000  // 2등이 1번 나와야 함
        ));
    }

    @Test
    void purchase_로또_구매_메서드_테스트() {
        Lotto lotto = new Lotto(new LottoTickets(),() -> new LottoTicket(1, 2, 3, 4, 5, 6));

        assertThat(lotto.purchaseLotto(2)).isEqualTo(new LottoTickets(new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,6")));
    }
}
