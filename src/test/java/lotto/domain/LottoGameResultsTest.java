package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameResultsTest {
    private LottoGameResults lottoGameResults;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp(){
        int inputMoneyAmount = 14000;

        this.lottoTickets = new LottoTickets(inputMoneyAmount);
        lottoTickets.issueLottoTicket(new ArrayList<>());

        this.lottoGameResults = new LottoGameResults(lottoTickets);

    }

    @DisplayName("LottoGameResults 수익률 계산 테스트")
    @Test
    void getProfitTest(){

        Map<PrizeUnit, Integer> winningResults = new HashMap<>();
        winningResults.put(PrizeUnit.findPrizeFieldByUnitCount(3, false), 1);
        winningResults.put(PrizeUnit.findPrizeFieldByUnitCount(4, false), 1);

        double profitResult = lottoGameResults.getProfit(winningResults);

        assertThat(profitResult).isEqualTo(3.93);

    }
}
