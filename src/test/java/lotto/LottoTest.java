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
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        assertThat(lottoTicketList).hasSize(3);
    }

    @Test
    void invalidLottoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 46)));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 5)));
    }
}
