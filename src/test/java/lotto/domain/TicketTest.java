package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    Ticket testTicket;

    @BeforeEach
    public void setTicket() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        Lottos autoLottos = new Lottos(Arrays.asList(lotto1, lotto2));
        Lottos manualLottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        testTicket = new Ticket(autoLottos, manualLottos);
    }

    @Test
    public void autoLottoSize() {
        // given
        int expectAutoSize = 2;
        // when
        int resultAutoSize = testTicket.autoLottoSize();
        // then
        assertThat(resultAutoSize).isEqualTo(expectAutoSize);
    }

    @Test
    public void manualLottoSize() {
        // given
        int expectManualSize = 3;
        // when
        int resultManualSize = testTicket.manualLottoSize();
        // then
        assertThat(resultManualSize).isEqualTo(expectManualSize);
    }

    @Test
    public void totalWinningResults() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Rank> expectWinningResults = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FOURTH, Rank.FIRST, Rank.SECOND);
        // when
        List<Rank> resultWinningResults = testTicket.winningResults(winningNumber);
        // then
        assertThat(resultWinningResults).isEqualTo(expectWinningResults);
    }

    @Test
    public void Ticket생성자_manual로만_만드는_경우() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        Ticket expectTicket = new Ticket(2, new Lottos(Arrays.asList(lotto1, lotto2)));
        int expectAutoSize = 0;
        int expectManualSize = 2;
        // when
        int resultAutoSize = expectTicket.autoLottoSize();
        int resultManualSize = expectTicket.manualLottoSize();

        // then
        assertThat(resultAutoSize).isEqualTo(expectAutoSize);
        assertThat(resultManualSize).isEqualTo(expectManualSize);
    }

}
