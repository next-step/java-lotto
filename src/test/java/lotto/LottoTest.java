package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    void convertAmountToTicketCount() {
        int amount = 14000;

        assertThat(Lotto.convertAmountToTicketCount(amount)).isEqualTo(14);
    }

    @Test
    void convertAmountToAutoTicketCount() {
        int amount = 14000;

        assertThat(Lotto.convertAmountToAutoTicketCount(amount, 20, false)).isEqualTo(14);
    }

    @Test
    void convertAmountToAutoTicketCount_정합성체크_활성화후_테스트() {
        int amount = 14000;

        assertThat(Lotto.convertAmountToAutoTicketCount(amount, 13, true)).isEqualTo(1);
    }

    @Test
    void convertAmountToAutoTicketCount_정합성체크활성한후_생성할수있는_로또수보다_많은로또수입력시_실패() {
        int amount = 14000;

        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.convertAmountToAutoTicketCount(amount, 20, true));
    }

    @Test
    void lotto_create_with_amount() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketCount()).isEqualTo(14);
    }

    @Test
    void lotto_create_with_ticketList() {
        Ticket ticket1 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket2 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        Lotto lotto = new Lotto(Arrays.asList(ticket1, ticket2));

        assertThat(lotto.getTicketCount()).isEqualTo(2);
    }

    @Test
    void lotto_create_with_amount_n_ticketList() {
        int amount = 14000;
        Ticket ticket1 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket2 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        Lotto lotto = new Lotto(amount, Arrays.asList(ticket1, ticket2));

        assertThat(lotto.getTicketCount()).isEqualTo(14);
    }

    @Test
    void lotto_create_with_amount_n_ticketList_구입금액적을시_실패() {
        int amount = 1000;
        Ticket ticket1 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket2 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(amount, Arrays.asList(ticket1, ticket2)));
    }

    @Test
    void lotto_create_with_amount_n_ticketList_matchAmountAndTicketList() {
        int amount = 14000;
        Ticket ticket1 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticket2 = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        Lotto lotto = new Lotto(amount, Arrays.asList(ticket1, ticket2), false);

        assertThat(lotto.getTicketCount()).isEqualTo(16);
    }


    @Test
    void getTicketCount() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketCount()).isEqualTo(14);
    }

    @Test
    void makeTicketList() {
        List<Ticket> lottoTickets = Lotto.makeTicketList(5);

        assertThat(lottoTickets).hasSize(5);
    }

    @Test
    void getTicketList() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketList()).hasSize(14);
    }

    @ParameterizedTest(name = "{index}. 번호매칭 - args : [{arguments}]")
    @CsvSource(value = {"1,2,3,4,5,6:6",
            "2,3,4,5,6,7:5",
            "3,4,5,6,7,8:4",
            "4,5,6,7,8,9:3",
            "5,6,7,8,9,10:2"}, delimiter = ':')
    void checkWinningNumbers(String ticketNumberText, int expected) {
        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        String[] tokens = ticketNumberText.split(",");
        List<Integer> ticketNumbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Ticket ticket = Ticket.of(ticketNumbers);

        int matchCount = Lotto.getWinningNumbersMatchCount(lottoWinningTicket, ticket);
        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    void increaseMatchCount() {
        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = 0;

        matchCount = Lotto.increaseMatchCount(lottoWinningTicket, LottoNumber.of(1), matchCount);
        assertThat(matchCount).isEqualTo(1);
    }
}
