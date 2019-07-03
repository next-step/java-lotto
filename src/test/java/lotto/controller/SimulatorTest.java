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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimulatorTest {
    @ParameterizedTest
    @ValueSource(ints = {14000, 12000, 2494, 142875})
    @DisplayName("Simulator에서 구입 수량에 맞게 여러장의 Ticket을 구매할 수 있다.")
    void buy_Tickets(int input) {
        List<Ticket> tickets = Simulator.buyTickets(new AutomaticTicketGenerator(), input);
        assertThat(tickets.size()).isEqualTo(input);
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

    @ParameterizedTest
    @CsvSource({
            "14000, 13, 1",
            "13500, 10, 3",
            "1488372, 1400, 88"
    })
    @DisplayName("Simulator에서 총 금액과 수동 티켓 구매 수량으로 자동 구매 수량을 계산한다.")
    void get_CountOfAutomaticTicket(int investMoney, int countOfManualTickets, int expectedResult) {
        int countOfAutoTickets = Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets);

        assertThat(countOfAutoTickets).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "14000, 15",
            "13500, 14",
            "1488372, 1500"
    })
    @DisplayName("수동 티켓이 구매 가능한 수량을 벗어나면 예외가 발생한다.")
    void check_CountOfManualTickets_ExceptionThrown(int investMoney, int countOfManualTickets) {
        assertThatThrownBy(() -> Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Simulator.MESSAGE_OF_TICKET_COUNT_IS_OVER);
    }

    @ParameterizedTest
    @CsvSource({
            "14000, -15",
            "13500, -14",
            "1488372, -1500"
    })
    @DisplayName("구매할 수동 티켓의 수량이 음수면 예외가 발생한다.")
    void check_NegativeCountOfManualTickets_ExceptionThrowm(int investMoney, int countOfManualTickets) {
        assertThatThrownBy(() -> Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Simulator.MESSAGE_OF_CANNOT_NEGATIVE_COUNT);
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
        List<Ticket> tickets = Simulator.buyTickets(new AutomaticTicketGenerator(), 1);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningTicket winningTicket = Simulator.drawWinningTicket(winningNumbers, bonusNumber);

        assertThat(Simulator.simulate(tickets, winningTicket)).isInstanceOf(Statistics.class);
    }
}

