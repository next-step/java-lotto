package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumberMatcherTest {
    @DisplayName("당첨통계를 구한다.")
    @Test
    void calculateAverage() {
        //given
        List<Integer> lastWeekWinningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<LottoTicket> lottoTickets = Arrays.asList(
          new LottoTicket(Arrays.asList(1,2,3,4,5,6)),
          new LottoTicket(Arrays.asList(2,3,4,5,6,7)),
          new LottoTicket(Arrays.asList(3,4,5,6,7,8)),
          new LottoTicket(Arrays.asList(4,5,6,7,8,9)),
          new LottoTicket(Arrays.asList(5,6,7,8,9,10)),
          new LottoTicket(Arrays.asList(6,7,8,9,10,11))
        );

        //when
        LottoNumberMatcher actual = new LottoNumberMatcher(lastWeekWinningNumbers, lottoTickets);

        //then
        Map<Integer, Integer> matchResult = new HashMap<>();
        matchResult.put(3,1);
        matchResult.put(4,1);
        matchResult.put(5,1);
        matchResult.put(6,1);
        LottoNumberMatcher expected = new LottoNumberMatcher(matchResult);

        assertEquals(expected, actual);
    }
}
