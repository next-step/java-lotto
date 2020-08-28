package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberMatcherTest {

    private LottoNumberMatcher lottoNumberMatcher;

    @BeforeEach
    void setUp() {
        Set<LottoNumber> numbers = IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());
        LottoTicket winningTicket = new LottoTicket(numbers);

        Set<LottoNumber> lottoNumbersOne = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
              .map(LottoNumber::new)
              .collect(Collectors.toSet());
        LottoTicket lottoTicketOne = new LottoTicket(lottoNumbersOne);

        Set<LottoNumber> lottoNumbersTwo = Arrays.asList(2, 3, 4, 5, 6, 7).stream()
              .map(LottoNumber::new)
              .collect(Collectors.toSet());
        LottoTicket lottoTicketTwo = new LottoTicket(lottoNumbersTwo);

        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicketOne, lottoTicketTwo);

        //when
        lottoNumberMatcher = new LottoNumberMatcher(lottoTickets, winningTicket);
    }

    @DisplayName("당첨통계를 구한다.")
    @Test
    void calculateAverage() {
        //then
        Map<Integer, Integer> matchResult = new HashMap<>();
        matchResult.put(5, 1);
        matchResult.put(6, 1);
        LottoNumberMatcher expected = new LottoNumberMatcher(matchResult);

        assertEquals(expected, lottoNumberMatcher);
    }

    @DisplayName("총 수익률 계산")
    @Test
    void calculateProfit() {
        long money = 4_000_000_000L;
        double actual = lottoNumberMatcher.calculateProfit(money);

        //then
        double expected = 0.51;
        assertEquals(expected, actual);
    }
}
