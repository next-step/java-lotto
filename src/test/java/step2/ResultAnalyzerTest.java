package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoRanking;
import step2.domain.ResultAnalyzer;
import step2.domain.Ticket;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultAnalyzerTest {

    @Test
    void getHitListCount() {
        Ticket matchTicket = new Ticket();
        int[] winningNumber = matchTicket.getNumbers();

        assertThat(
                ResultAnalyzer.getHitListCount(winningNumber, Arrays.asList(matchTicket), winningNumber.length)
        ).isEqualTo(1);

        assertThat(
                ResultAnalyzer.getHitListCount(winningNumber, Arrays.asList(matchTicket), winningNumber.length - 1)
        ).isEqualTo(0);
    }

    @Test
    void getRateReturn() {
        Ticket matchTicket = new Ticket();
        int[] winningNumber = matchTicket.getNumbers();

        assertThat(
                ResultAnalyzer.getRateReturn(winningNumber, Arrays.asList(matchTicket), LottoRanking.FIRST.getPrizeMoney())
        ).isEqualTo(1.0);
    }
}