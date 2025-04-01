package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void lottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    void lottoNumbersSorted() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        assertThat(lottoNumbers).isSorted();
    }

    @Test
    void lottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(3000);
        assertThat(lottoTickets.getLottoTicketCount()).isEqualTo(3);
    }

    @Test
    void invalidLottoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 46)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 5)));
    }

    @Test
    void lottoRank() {
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        LottoTicket rank1Ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(rank1Ticket.calculateRank(winningTicket)).isEqualTo(Rank.FIRST);

        LottoTicket rank3Ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        assertThat(rank3Ticket.calculateRank(winningTicket)).isEqualTo(Rank.THIRD);

        LottoTicket rank4Ticket = new LottoTicket(List.of(1, 2, 3, 4, 7, 8));
        assertThat(rank4Ticket.calculateRank(winningTicket)).isEqualTo(Rank.FOURTH);

        LottoTicket rank5Ticket = new LottoTicket(List.of(1, 2, 3, 7, 8, 9));
        assertThat(rank5Ticket.calculateRank(winningTicket)).isEqualTo(Rank.FIFTH);

        LottoTicket unrankedTicket = new LottoTicket(List.of(1, 2, 7, 8, 9, 10));
        assertThat(unrankedTicket.calculateRank(winningTicket)).isEqualTo(Rank.MISS);
    }
}
