package lotto.domain;

import lotto.LottoErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameResultsTest {
    private LottoGameResults lottoGameResults;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp(){
        // given
        int inputMoneyAmount = 14000;

        this.lottoGameResults = new LottoGameResults(inputMoneyAmount);

        int[] numbers = {1,2,3,4,5,6};
        this.winningNumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets(inputMoneyAmount);

        lottoTickets.getLottoTickets()
                .stream().forEach(lottoTicket -> lottoGameResults.addResult(new LottoGameResult(lottoTicket.getSortedLottoNumbers())));

    }

    @DisplayName("지난 당첨 번호 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"3%4%6%7%8%9", "q,w,e,r,t,y", "1,2,3"})
    void illegalLastWinningNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGameResults.addLastWinningNumber(input);
        }).withMessageContaining(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
    }

    @DisplayName("일치하는 당첨번호 갯수 계산 테스트")
    @Test
    void countWinningNumbersTest(){
        int[] numbers = {1,2,3,7,8,9};
        List<Integer> gameResult = IntStream.of(numbers).boxed().collect(Collectors.toList());

        int winningNumberCount = lottoGameResults.countWinningNumbers(gameResult, winningNumbers);

        assertThat(winningNumberCount).isEqualTo(3);

    }

    @DisplayName("최소 당첨번호 갯수 미만인 경우 0리턴 테스트")
    @Test
    void countWinningNumbersUnderMinToPrizeTest(){
        int[] numbers = {1,2,44,55,66,77};
        List<Integer> gameResult = IntStream.of(numbers).boxed().collect(Collectors.toList());

        int winningNumberCount = lottoGameResults.countWinningNumbers(gameResult, winningNumbers);

        assertThat(winningNumberCount).isEqualTo(0);

    }



    @DisplayName("LottoGameResults 수익률 계산 테스트")
    @Test
    void getProfitTest(){

        Map<Integer, Integer> winningResults = new HashMap<>();
        winningResults.put(3, 1);
        winningResults.put(4, 1);

        double profitResult = lottoGameResults.getProfit(winningResults);

        assertThat(profitResult).isEqualTo(3.93);

    }
}
