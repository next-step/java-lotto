package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    private static Stream<Arguments> provideCountNumberOfMatchingTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),  //lottoWinningNumbers
                        createLottoListFrom(
                                LottoTicket.from(30, 20, 25, 1, 2, 3),  //3개 일치
                                LottoTicket.from(30, 20, 25, 1, 2, 3),  //3개 일치
                                LottoTicket.from(1, 2, 3, 4, 5, 43)),   //5개 일치
                        createNumberOfMatchingMap(
                                "3:2", "5:1"
                        )
                ),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                        createLottoListFrom(
                                LottoTicket.from(30, 20, 25, 40, 43, 33),   //0개 일치
                                LottoTicket.from(30, 34, 20, 25, 40, 43),    //0개 일치
                                LottoTicket.from(14, 30, 20, 25, 40, 43)),     //0개 일치
                        createNumberOfMatchingMap("0:3")
                ),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),
                        createLottoListFrom(
                                LottoTicket.from(30, 20, 25, 6, 43, 33),   //1개 일치
                                LottoTicket.from(1, 34, 20, 25, 40, 43),    //1개 일치
                                LottoTicket.from(2, 34, 20, 25, 40, 43),    //1개 일치
                                LottoTicket.from(6, 5, 4, 3, 2, 1)),   //6개 일치
                        createNumberOfMatchingMap(
                                "1:3", "6:1"
                        )
                )

        );
    }

    private static List<LottoTicket> createLottoListFrom(LottoTicket... lottoTickets) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        Collections.addAll(lottoTicketList, lottoTickets);
        return lottoTicketList;
    }

    private static Map<Integer, Integer> createNumberOfMatchingMap(String... pair) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String p : pair) {
            String[] keyValue = p.split(":");
            map.put(Integer.parseInt(keyValue[0]), Integer.parseInt(keyValue[1]));
        }
        return map;
    }

    @DisplayName("로또 당첨 번호를 전달하면 일치하는 개수가 몇 개 있는지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("provideCountNumberOfMatchingTest")
    void countNumberOfMatching(List<Integer> winningNumbers, List<LottoTicket> lottoTicketList, Map<Integer, Integer> expectedCountNumberOfMatching) {
        //given
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers, 6);
        LottoWinningRules lottoWinningRules = new LottoWinningRules();
        LottoTickets lottoTickets = new LottoTickets(lottoWinningRules, lottoTicketList, 2000);

        //when
        Map<Integer, Integer> countNumberOfMatching = lottoTickets.countNumberOfMatching(lottoWinningNumbers);

        //then
        assertThat(countNumberOfMatching).isEqualTo(expectedCountNumberOfMatching);

    }

//    @DisplayName("로또 당첨금을 계산한다.")
//    @Test
//    void getPrizeMoney() {
//        //given
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);
//
//        LottoWinningRules lottoWinningRules = new LottoWinningRules();
//
//        LottoTicket lottoTicket1 = LottoTicket.from(30, 20, 25, 1, 2, 3); //3개일치
//        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 4, 5, 43); //5개 일치
//        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);
//
//        LottoTickets lottoTickets = new LottoTickets(lottoWinningRules, lottoTicketList, 2000);
//
//        //when
//        int prizeMoney = lottoTickets.prizeMoney(lottoWinningNumbers);
//
//        //then
//        assertThat(prizeMoney).isEqualTo(1505000);
//    }

//    @DisplayName("로또 당첨 번호를 인자로 전달받아 수익률을 계산한다.")
//    @Test
//    void earningRateFromLottoWinningNumbers() {
//        //given
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);
//
//        LottoWinningRules lottoWinningRules = new LottoWinningRules();
//
//        LottoTicket lottoTicket1 = LottoTicket.from(30, 20, 25, 1, 2, 3); //3개일치
//        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 33, 22, 43); //3개 일치
//        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);
//
//        LottoTickets lottoTickets = new LottoTickets(lottoWinningRules, lottoTicketList, 2000);
//
//        //when
//        double earningRate = lottoTickets.earningRate(lottoWinningNumbers);
//
//        //then
//        assertThat(earningRate).isEqualTo(5);
//    }

//    @DisplayName("일치하는 로또 번호 수를 전달하여 수익률을 계산한다.")
//    @Test
//    void earningRateFromCountOfMatching() {
//        //given
//        Map<Integer, Integer> countOfMatchingMap = new HashMap<>();
//        countOfMatchingMap.put(3, 2);
//
//        LottoWinningRules lottoWinningRules = new LottoWinningRules();
//
//        LottoTicket lottoTicket1 = LottoTicket.from(30, 20, 25, 1, 2, 3); //3개일치
//        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 33, 22, 43); //3개 일치
//        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);
//
//        LottoTickets lottoTickets = new LottoTickets(lottoWinningRules, lottoTicketList, 2000);
//
//        //when
//        double earningRate = lottoTickets.earningRate(countOfMatchingMap);
//
//        //then
//        assertThat(earningRate).isEqualTo(5);
//    }

}