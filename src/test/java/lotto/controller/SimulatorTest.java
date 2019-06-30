package lotto.controller;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimulatorTest {
    @ParameterizedTest
    @ValueSource(ints = {14000, 12000, 2494, 142875})
    @DisplayName("Simulator에서 구입 금액에 맞게 여러장의 Ticket을 구매할 수 있다.")
    void buy_Tickets(int input) {
        int expectedCount = input / Money.TICKET_PRICE;
        List<Ticket> tickets = Simulator.buyTickets(input);

        assertThat(tickets.size()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
            "14000, 14000",
            "13500, 13000",
            "1488372, 1488000"
    })
    @DisplayName("Simulator에서 실제 티켓을 구매하는데 사용한 금액을 계산할 수 있다.")
    void get_PurchasePrice(int input, int expectedResult) {
        assertThat(Simulator.getPurchasePrice(input)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Simulator에서 당첨 티켓을 뽑을 수 있다.")
    void get_WinningTicket() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(Simulator.drawWinningTicket(winningNumbers, bonusNumber)).isInstanceOf(WinningTicket.class);
    }

    @Test
    @DisplayName("Simulator에서 로또 진행 결과를 Statistics 객체로 반환한다.")
    void simulate_PlayLotto() {
        List<Ticket> tickets = Simulator.buyTickets(10000);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningTicket winningTicket = Simulator.drawWinningTicket(winningNumbers, bonusNumber);

        assertThat(Simulator.simulate(tickets, winningTicket)).isInstanceOf(Statistics.class);
    }

    @Test
    @DisplayName("Simulator에서 로또 수익률을 계산할 수 있다.")
    void calculate_ProfitRatio() {
        Statistics statistics = new Statistics();
        statistics.put(Rank.FIFTH);

        assertThat(Simulator.getProfitRate(statistics, 14000)).isBetween(0.35, 0.35);
    }
}
