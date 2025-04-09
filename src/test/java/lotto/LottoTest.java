package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;
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
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5)))));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(46)))));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(5)))));
    }

    @Test
    void lottoRank() {
        LottoTicket winningTicket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningResult winningResult = new WinningResult(winningTicket, bonusNumber);

        LottoTicket rank1Ticket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
        assertThat(winningResult.calculateRank(rank1Ticket)).isEqualTo(Rank.FIRST);

        LottoTicket rank2Ticket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))));
        assertThat(winningResult.calculateRank(rank2Ticket)).isEqualTo(Rank.SECOND);

        LottoTicket rank3Ticket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))));
        assertThat(winningResult.calculateRank(rank3Ticket)).isEqualTo(Rank.THIRD);

        LottoTicket rank4Ticket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(7), LottoNumber.of(8))));
        assertThat(winningResult.calculateRank(rank4Ticket)).isEqualTo(Rank.FOURTH);

        LottoTicket rank5Ticket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9))));
        assertThat(winningResult.calculateRank(rank5Ticket)).isEqualTo(Rank.FIFTH);

        LottoTicket unrankedTicket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10))));
        assertThat(winningResult.calculateRank(unrankedTicket)).isEqualTo(Rank.MISS);
    }

    @Test
    void validateBonusNumber() {
        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(0)));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(lottoTicket, LottoNumber.of(46)));
    }

    @Test
    void validateManualTicketCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTickets(1000, List.of(new LottoTicket(), new LottoTicket())));
    }
}
