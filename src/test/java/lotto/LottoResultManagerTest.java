package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    @Test
    public void 수익률_계산() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createTicket(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(LottoTicket.createTicket(List.of(11, 22, 33, 34, 35, 45)));
        tickets.add(LottoTicket.createTicket(List.of(10, 20, 30, 40, 43, 44)));
        tickets.add(LottoTicket.createTicket(List.of(13, 23, 33, 43, 44, 45)));
        List<Integer> winningNumbers = List.of(11, 22, 33, 34, 36, 37);
        LottoResultManager manager = new LottoResultManager(tickets,
            new WinLotto(winningNumbers, 44));
        assertThat(manager.calculateReturnRate()).isEqualTo(12.5);
    }

    @Test
    public void 당첨_결과_개수() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createTicket(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(LottoTicket.createTicket(List.of(11, 22, 33, 34, 35, 45)));
        tickets.add(LottoTicket.createTicket(List.of(10, 20, 30, 40, 43, 44)));
        tickets.add(LottoTicket.createTicket(List.of(13, 23, 33, 43, 44, 45)));
        List<Integer> winningNumbers = List.of(11, 22, 33, 34, 36, 37);
        LottoResultManager manager = new LottoResultManager(tickets,
            new WinLotto(winningNumbers, 44));

        assertThat(manager.getLottoResult().get(LottoPrice.MISS)).isEqualTo(3);
        assertThat(manager.getLottoResult().get(LottoPrice.FIFTH)).isEqualTo(null);
        assertThat(manager.getLottoResult().get(LottoPrice.FOURTH)).isEqualTo(1);
        assertThat(manager.getLottoResult().get(LottoPrice.THIRD)).isEqualTo(null);
        assertThat(manager.getLottoResult().get(LottoPrice.SECOND)).isEqualTo(null);
        assertThat(manager.getLottoResult().get(LottoPrice.FIRST)).isEqualTo(null);
    }


}
