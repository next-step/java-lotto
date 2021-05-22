package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.enums.Prize;

public class LottoSponsorTest {

    List<Ticket> tickets = Arrays.asList(
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,11"),
        new Ticket("1,2,3,4,10,11")
    );
    Ticket winningTicket = new Ticket("1,2,3,4,5,6");
    Purchase purchase = new Purchase("1000");
    LottoSponsor lottoSponsor = new LottoSponsor(tickets, winningTicket, purchase);
    Map<Prize, Integer> scores = new EnumMap<>(Prize.class);

    @BeforeEach
    void setUp() {
        scores.put(Prize.SIX, 2);
        scores.put(Prize.FIVE, 1);
        scores.put(Prize.FOUR, 1);
        scores.put(Prize.THREE, 0);
        scores.put(Prize.TWO, 0);
        scores.put(Prize.ONE, 0);
        scores.put(Prize.ZERO, 0);
    }

    @DisplayName("당첨된 티켓 수를 센다.")
    @Test
    void countScores() {
        assertThat(lottoSponsor.countScores(tickets, winningTicket)).isEqualTo(scores);
    }

    @DisplayName("총 당첨금을 계산한다.")
    @Test
    void sumPrizeMoney() {
        Long expectedTotalPrizeMoney = 4_001_550_000L;

        assertThat(lottoSponsor.sumPrizeMoney(scores)).isEqualTo(expectedTotalPrizeMoney);
    }

    @DisplayName("수익률을 계산한다. 소수점 2자리 아래 버림")
    @ParameterizedTest(name = "총 당첨금: \"{0}\", 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"0,1000,0.00", "2000000000,1000,2000000.00", "55000,2000,27.50", "5000,14000,0.35"})
    void convertToEarningRate(long money, int payment, float rate) {
        assertThat(lottoSponsor.convertToEarningRate(money, payment)).isEqualTo(rate);
    }
}
