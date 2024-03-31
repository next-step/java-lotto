package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultManagerTest {

    @ParameterizedTest
    @CsvSource({"10000, 5", "15000, 3.33"})
    public void 수익률_계산(int amount, double expect) {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createTicket(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(LottoTicket.createTicket(List.of(11, 22, 33, 34, 35, 45)));
        tickets.add(LottoTicket.createTicket(List.of(10, 20, 30, 40, 43, 44)));
        tickets.add(LottoTicket.createTicket(List.of(13, 23, 33, 43, 44, 45)));
        List<Integer> winningNumbers = List.of(11, 22, 33, 34, 36, 37);
        LottoResultManager manager = new LottoResultManager(tickets,
            new WinLotto(winningNumbers, 44));
        assertThat(manager.calculateReturnRate(amount)).isEqualTo(expect);
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

        assertThat(manager.getCount(LottoPrice.MISS)).isEqualTo(3);
        assertThat(manager.getCount(LottoPrice.FIFTH)).isEqualTo(0);
        assertThat(manager.getCount(LottoPrice.FOURTH)).isEqualTo(1);
        assertThat(manager.getCount(LottoPrice.THIRD)).isEqualTo(0);
        assertThat(manager.getCount(LottoPrice.SECOND)).isEqualTo(0);
        assertThat(manager.getCount(LottoPrice.FIRST)).isEqualTo(0);


    }


}
