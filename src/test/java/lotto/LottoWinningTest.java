package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningTicket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTest {
    @Test
    void winningLottoMakeTest() {
         List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        LottoWinningTicket winningTicket = new LottoWinningTicket(numbers);
        assertThat(winningTicket).isNotNull();
    }

    @Test
    void winningLottoExceptionTest() {
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        assertThatThrownBy(() ->new LottoWinningTicket(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void winningLottoMatchingTest() {
        List<Integer> winningNumber = Arrays.asList(1,5,6,9,10,13);
        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(winningNumber);
        LottoTickets lottoTickets = new LottoTickets(100);
        LottoMachine.winningResult(lottoWinningTicket, lottoTickets);
    }


}
