package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "15000,15"})
    void 자동로또_구입금액에_따른_로또티켓_개수_확인_(int moneyToBuyTicket, int numberOfTickets) {
        assertThat(LottoGame.buy(moneyToBuyTicket).size()).isEqualTo(numberOfTickets);
    }

    @Test
    void 수동_로또_입력한대로_구입되었는지_확인() {
        List<Integer> manual1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> manual2 = List.of(7, 8, 9, 10, 11, 12);
        List<List<Integer>> manualTicketNumbers = List.of(manual1, manual2);

        List<LottoTicket> result = LottoGame.buy(10000, manualTicketNumbers);
        assertThat(result.size()).isEqualTo(10);
        assertThat(result).contains(LottoTicket.createFromIntegerList(manual1));
        assertThat(result).contains(LottoTicket.createFromIntegerList(manual2));
    }
}
