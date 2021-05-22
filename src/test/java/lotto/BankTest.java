package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BankTest {

    List<Ticket> tickets = Arrays.asList(
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,11"),
        new Ticket("1,2,3,4,10,11")
    );
    Ticket winningTicket = new Ticket("1,2,3,4,5,6");

    @DisplayName("당첨된 티켓 수를 센다.")
    @Test
    void countScores() {
        List<Integer> expected = Arrays.asList(0, 0, 0, 0, 1, 1, 2);
        assertThat(Bank.countScores(tickets, winningTicket)).isEqualTo(expected);
    }

    @DisplayName("총 당첨금을 계산한다.")
    @Test
    void sumPrizeMoney() {
        List<Integer> scores = Arrays.asList(0, 0, 0, 1, 2, 3, 4);
        Long expected = 8_004_605_000L;
        assertThat(Bank.sumPrizeMoney(scores)).isEqualTo(expected);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest(name = "총 당첨금: \"{0}\", 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"0,1000,-1.00", "2000000000,1000,1999999.00", "55000,2000,26.50"})
    void convertToEarningRate(long money, int payment, float rate) {
        assertThat(Bank.convertToEarningRate(money, payment)).isEqualTo(rate);
    }
}
