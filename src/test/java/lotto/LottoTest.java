package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void lottoNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    void lottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    void lottoNumbersSorted() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        assertThat(lottoNumbers).isSorted();
    }

    @Test
    void lottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(3000, List.of());
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
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningResult winningResult = new WinningResult(winningTicket, bonusNumber);

        LottoTicket rank1Ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningResult.calculateRank(rank1Ticket)).isEqualTo(Rank.FIRST);

        LottoTicket rank2Ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningResult.calculateRank(rank2Ticket)).isEqualTo(Rank.SECOND);

        LottoTicket rank3Ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningResult.calculateRank(rank3Ticket)).isEqualTo(Rank.THIRD);

        LottoTicket rank4Ticket = new LottoTicket(List.of(1, 2, 3, 4, 7, 8));
        assertThat(winningResult.calculateRank(rank4Ticket)).isEqualTo(Rank.FOURTH);

        LottoTicket rank5Ticket = new LottoTicket(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningResult.calculateRank(rank5Ticket)).isEqualTo(Rank.FIFTH);

        LottoTicket unrankedTicket = new LottoTicket(List.of(1, 2, 7, 8, 9, 10));
        assertThat(winningResult.calculateRank(unrankedTicket)).isEqualTo(Rank.MISS);
    }

    @Test
    void validateBonusNumber() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(0)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(46)));
    }

    @Test
    void validateManualTicketCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTickets(1000, List.of(new LottoTicket(), new LottoTicket())));
    }
}
