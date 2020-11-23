package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameResultsTest {
    private LottoGameResults lottoGameResults;
    private List<Integer> winningNumbers;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp(){
        // given
        int inputMoneyAmount = 14000;

        this.lottoTickets = new LottoTickets(inputMoneyAmount);

        this.lottoGameResults = new LottoGameResults(lottoTickets);

        int[] numbers = {1,2,3,4,5,6};

        this.winningNumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());

    }

    @DisplayName("LottoGameResults 수익률 계산 테스트")
    @Test
    void getProfitTest(){

        Map<WinResult, Integer> winningResults = new HashMap<>();
        winningResults.put(new WinResult(3, false), 1);
        winningResults.put(new WinResult(4, false), 1);

        double profitResult = lottoGameResults.getProfit(winningResults);

        assertThat(profitResult).isEqualTo(3.93);

    }
}
