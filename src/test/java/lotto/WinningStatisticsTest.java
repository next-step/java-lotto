package lotto;

import lotto.winning.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    List<Integer> winningNumbers;
    WinningStatistics winningStatistics;
    List<LottoTicket> tickets;

    @BeforeEach
    void setUp() {
        Integer[] numbers = {4,1,7,3,12,22};
        winningNumbers = new ArrayList<>(Arrays.asList(numbers));
        winningStatistics = new WinningStatistics();

        tickets = new ArrayList<>();
        Integer[] lottoOne = {1,2,3,4,5,6};
        Integer[] lottoTwo = {4,1,7,3,12,31};
        Integer[] lottoThree = {9,11,8,6,2,17};

        LottoTicket lottoTicketOne = new LottoTicket(Arrays.asList(lottoOne));
        LottoTicket lottoTicketTwo = new LottoTicket(Arrays.asList(lottoTwo));
        LottoTicket lottoTicketThree = new LottoTicket(Arrays.asList(lottoThree));

        tickets.add(lottoTicketOne);
        tickets.add(lottoTicketTwo);
        tickets.add(lottoTicketThree);
    }

    @DisplayName("로또 한장 당첨 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,4,5,45,2,1:3", "1,2,3,4,5,6:3", "12,3,7,22,1,4:6"}, delimiter = ':')
    void calculateTicketWinningPoint(String ticket, int expected) {
        String[] ticketArray = ticket.split(",");
        List<Integer> ticketList = new ArrayList<>();
        for (int i = 0; i < ticketArray.length; i++) {
            ticketList.add(Integer.parseInt(ticketArray[i]));
        }
        LottoTicket lottoTicket = new LottoTicket(ticketList);

        int winningPoint = winningStatistics.calculateTicketWinningPoint(lottoTicket, winningNumbers);
        assertThat(winningPoint).isEqualTo(expected);
    }

    @DisplayName("당첨번호안에 로또 숫자 포함 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "12:1", "44:0"}, delimiter = ':')
    void checkContainNumber(int lottoNumber, int expected) {
        int result = winningStatistics.checkContainNumber(winningNumbers, lottoNumber);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구매한 개수 전체 로또 당첨 확인")
    @Test
    void calculateTotalLottoTickets() {
        winningStatistics.calculateTotalWinningPoint(tickets, winningNumbers);
        assertThat(winningStatistics.getWinningPoints()).containsExactly(1, 0, 0, 1, 0, 1, 0);
    }

    @DisplayName("당첨 금액 환산")
    @Test
    void changeWinningPointsToMoney() {
        winningStatistics.calculateTotalWinningPoint(tickets, winningNumbers);
        int winningPointsMoney = winningStatistics.changeWinningPointsToMoney(winningStatistics.getWinningPoints());
        assertThat(winningPointsMoney).isEqualTo(1505000);
    }

    @DisplayName("총 수익률 계산값 확인")
    @ParameterizedTest
    @CsvSource(value = {"5000:0.35","50000:3.57","0:0"}, delimiter = ':')
    void calculateTotalYield(int winningPointMoney, double expected) {
        int purchacePrice = 14000;
        double yield = winningStatistics.calculateTotalYield(winningPointMoney, purchacePrice);
        assertThat(yield).isEqualTo(expected);
    }
}
