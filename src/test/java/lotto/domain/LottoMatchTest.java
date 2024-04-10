package lotto.domain;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @Test
    void 상금계산(){
        int matchCount = 1;
        assertThat(LottoMatchNumber.MATCH3.totalPrizeMoney(matchCount)).isEqualTo(5000);
    }

    @Test
    void 당첨_테스트(){
       LottoMatch lottoMatch= new LottoMatch("1, 2, 3, 4, 5, 6");

        List<Integer> ticketNumbers1 = new ArrayList<>();
        ticketNumbers1.add(1);
        ticketNumbers1.add(2);
        ticketNumbers1.add(3);
        ticketNumbers1.add(4);
        ticketNumbers1.add(5);
        ticketNumbers1.add(7);
        LottoTicket lottoTicket1 = new LottoTicket(ticketNumbers1);

        List<Integer> ticketNumbers2 = new ArrayList<>();
        ticketNumbers2.add(1);
        ticketNumbers2.add(2);
        ticketNumbers2.add(3);
        ticketNumbers2.add(4);
        ticketNumbers2.add(5);
        ticketNumbers2.add(7);
        LottoTicket lottoTicket2 = new LottoTicket(ticketNumbers2);

        List<LottoTicket> myNumbers = new ArrayList<>();
        myNumbers.add(lottoTicket1);
        myNumbers.add(lottoTicket2);

        HashMap<LottoMatchNumber, Integer> results = lottoMatch.matchResult(myNumbers);

        assertThat(results.get(LottoMatchNumber.MATCH5)).isEqualTo(2);
    }

}
