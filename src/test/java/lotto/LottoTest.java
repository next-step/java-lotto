package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void lottoNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(47));
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
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5))));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(46))));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(5))));
    }

    @Test
    void lottoRank() {
        LottoTicket winningTicket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningResult winningResult = new WinningResult(winningTicket, bonusNumber);

        LottoTicket rank1Ticket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(winningResult.calculateRank(rank1Ticket)).isEqualTo(Rank.FIRST);

        LottoTicket rank2Ticket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        assertThat(winningResult.calculateRank(rank2Ticket)).isEqualTo(Rank.SECOND);

        LottoTicket rank3Ticket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(8)));
        assertThat(winningResult.calculateRank(rank3Ticket)).isEqualTo(Rank.THIRD);

        LottoTicket rank4Ticket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)));
        assertThat(winningResult.calculateRank(rank4Ticket)).isEqualTo(Rank.FOURTH);

        LottoTicket rank5Ticket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        assertThat(winningResult.calculateRank(rank5Ticket)).isEqualTo(Rank.FIFTH);

        LottoTicket unrankedTicket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10)));
        assertThat(winningResult.calculateRank(unrankedTicket)).isEqualTo(Rank.MISS);
    }

    @Test
    void validateBonusNumber() {
        LottoTicket lottoTicket = new LottoTicket(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, new LottoNumber(6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, new LottoNumber(0)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, new LottoNumber(46)));
    }

    @Test
    void validateManualTicketCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTickets(1000, List.of(new LottoTicket(), new LottoTicket())));
    }
}
