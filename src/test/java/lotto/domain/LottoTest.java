package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    private Lotto lotto;

    @DisplayName("가격을 기준으로 티켓 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTicketsTest")
    public void calculateTicketsTest(int money, int tickets) {
        assertEquals(tickets, new Price(money).calculateTickets());
    }

    private static Stream<Arguments> provideCalculateTicketsTest() {
        return Stream.of(
            Arguments.of(24000, 24),
            Arguments.of(1000, 1)
        );
    }

    @DisplayName("티켓 별 당첨 통계내기 테스트")
    @ParameterizedTest
    @MethodSource("provideStatisticsTicketTest")
    public void statisticsTicketTest(WinningNumber winningNumber, List<Ticket> tickets, HashMap<Revenue, Integer> revenueMap) {
        lotto = new Lotto(winningNumber, tickets);
        assertEquals(revenueMap, lotto.statisticsTicket());
    }

    private static Stream<Arguments> provideStatisticsTicketTest() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        revenueMap.put(Revenue.NOTHING,2);
        Map<Revenue, Integer> revenueMap1 = new HashMap<>();
        revenueMap1.put(Revenue.NOTHING,1);
        revenueMap1.put(Revenue.THREE_MATCHES,1);
        Map<Revenue, Integer> revenueMap2 = new HashMap<>();
        revenueMap2.put(Revenue.THREE_MATCHES,1);
        revenueMap2.put(Revenue.FIVE_AND_BONUS_MATCHES,1);
        return Stream.of(
            Arguments.of(new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),7)
                ,Arrays.asList(
                new Ticket(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Ticket(Arrays.asList(3, 5, 11, 16, 32, 38)))
                ,revenueMap),
            Arguments.of(new WinningNumber(new Ticket(Arrays.asList(41, 42, 43, 4, 5, 7)),7)
                ,Arrays.asList(
                    new Ticket(Arrays.asList(8, 21, 23, 41, 42, 43)),
                    new Ticket(Arrays.asList(3, 5, 11, 16, 32, 38)))
                ,revenueMap1),
            Arguments.of(new WinningNumber(new Ticket(Arrays.asList(41, 42, 43, 4, 5, 7)),38)
                ,Arrays.asList(
                    new Ticket(Arrays.asList(8, 21, 23, 41, 42, 43)),
                    new Ticket(Arrays.asList(41, 42, 43, 4, 5, 38)))
                ,revenueMap2)
        );
    }

    @DisplayName("총 티켓 당첨금 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTotalPrizeTest")
    public void calculateTotalPrizeTest(Map<Revenue, Integer> revenue, int expected) {
        lotto = new Lotto();
        int totalRevenue = lotto.calculateTotalPrize(revenue);
        assertEquals(expected, totalRevenue);
    }

    private static Stream<Arguments> provideCalculateTotalPrizeTest() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        revenueMap.put(Revenue.NOTHING,1);
        revenueMap.put(Revenue.THREE_MATCHES,1);
        revenueMap.put(Revenue.FIVE_AND_BONUS_MATCHES, 2);
        return Stream.of(
            Arguments.of(revenueMap, 60005000)
        );
    }

}
