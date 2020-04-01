package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTest {
    @Test
    void winningLottoMakeTest() {
         List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket winningTicket = new LottoTicket(numbers);
        assertThat(winningTicket).isNotNull();
    }

    @Test
    void winningLottoExceptionTest() {
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        assertThatThrownBy(() ->new LottoTicket(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void winningLottoMatchingTest() {
        List<Integer> winningNumber = Arrays.asList(1,5,6,9,10,13);
        LottoTicket LottoTicket = new LottoTicket(winningNumber);
        LottoTickets lottoTickets = new LottoTickets(100);
        LottoMachine.winningResult(LottoTicket, lottoTickets);
    }


}
