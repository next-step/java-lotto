package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    private Lotto lotto;

    @DisplayName("티켓 별 당첨 통계내기 테스트")
    @ParameterizedTest
    @MethodSource("provideStatisticsTicketTest")
    public void statisticsTicketTest(WinningInfo winningInfo, Tickets tickets, HashMap<Revenue, Integer> revenueMap) {
        lotto = new Lotto(winningInfo, tickets);
        assertEquals(revenueMap, lotto.statisticsTicket());
    }

    private static Stream<Arguments> provideStatisticsTicketTest() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        revenueMap.put(Revenue.NOTHING, 2);
        Map<Revenue, Integer> revenueMap1 = new HashMap<>();
        revenueMap1.put(Revenue.NOTHING, 1);
        revenueMap1.put(Revenue.THREE, 1);
        Map<Revenue, Integer> revenueMap2 = new HashMap<>();
        revenueMap2.put(Revenue.THREE, 1);
        revenueMap2.put(Revenue.FIVE_AND_BONUS, 1);
        return Stream.of(
            Arguments.of(new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(
                        Collectors.toList()))
                ), new LottoNumber(7))
                , new Tickets(Arrays.asList(
                    new Ticket(Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::new).collect(
                        Collectors.toList())),
                    new Ticket(Stream.of(3, 5, 11, 16, 32, 38).map(LottoNumber::new).collect(
                        Collectors.toList()))
                )), revenueMap),
            Arguments.of(new WinningInfo(new WinningNumber(
                   new Ticket(Stream.of(41, 42, 43, 4, 5, 7).map(LottoNumber::new).collect(
                       Collectors.toList()))
                ), new LottoNumber(7))
                , new Tickets(Arrays.asList(
                    new Ticket(Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::new).collect(
                        Collectors.toList())),
                    new Ticket(Stream.of(3, 5, 11, 16, 32, 38).map(LottoNumber::new).collect(
                        Collectors.toList())))
                ), revenueMap1),
            Arguments.of(new WinningInfo(new WinningNumber(
                    new Ticket(Stream.of(41, 42, 43, 4, 5, 7).map(LottoNumber::new).collect(
                        Collectors.toList()))
                ), new LottoNumber(38))
                , new Tickets(Arrays.asList(
                    new Ticket(Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::new).collect(
                        Collectors.toList())),
                    new Ticket(Stream.of(41, 42, 43, 4, 5, 38).map(LottoNumber::new).collect(
                        Collectors.toList())))
                ), revenueMap2)
        );
    }

}
