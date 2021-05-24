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
        new Ticket("1,2,3,5,8,13"), // SIX
        new Ticket("1,2,3,5,8,21"), // BONUS
        new Ticket("1,2,3,5,13,45"), // FIVE
        new Ticket("1,2,3,5,44,45"), // FOUR
        new Ticket("1,2,3,43,44,45"), // THREE
        new Ticket("1,2,42,43,44,45"), // TWO
        new Ticket("1,41,42,43,44,45"), // ONE
        new Ticket("40,41,42,43,44,45") // ZERO
    );
    Ticket winningTicket = new Ticket("1,2,3,5,8,13");
    BonusNumber bonusNumber = new BonusNumber("21", winningTicket);
    Purchase purchase = new Purchase("1000");
    LottoSponsor lottoSponsor = new LottoSponsor(tickets, winningTicket, purchase, bonusNumber);
    Map<Prize, Integer> answer = new EnumMap<>(Prize.class);
    Long expectedTotalPrizeMoney = 0L;

    @BeforeEach
    void setUp() {
        answer.put(Prize.BONUS, 1);
        answer.put(Prize.SIX, 1);
        answer.put(Prize.FIVE, 1);
        answer.put(Prize.FOUR, 1);
        answer.put(Prize.THREE, 1);
        answer.put(Prize.TWO, 1);
        answer.put(Prize.ONE, 1);
        answer.put(Prize.ZERO, 1);

        for (Prize prize : Prize.values()) {
            expectedTotalPrizeMoney += (long)prize.getPrize();
        }
    }

    @DisplayName("당첨된 티켓 수를 센다.")
    @Test
    void countScores() {
        assertThat(lottoSponsor.countScores(tickets, winningTicket, bonusNumber)).isEqualTo(answer);
    }

    @DisplayName("총 당첨금을 계산한다.")
    @Test
    void sumPrizeMoney() {
        assertThat(lottoSponsor.sumPrizeMoney(answer)).isEqualTo(expectedTotalPrizeMoney);
    }

    @DisplayName("수익률을 계산한다. 소수점 2자리 아래 버림")
    @ParameterizedTest(name = "총 당첨금: \"{0}\", 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"0,1000,0.00", "2000000000,1000,2000000.00", "55000,2000,27.50", "5000,14000,0.35"})
    void convertToEarningRate(long money, int payment, float rate) {
        assertThat(lottoSponsor.convertToEarningRate(money, payment)).isEqualTo(rate);
    }

}
