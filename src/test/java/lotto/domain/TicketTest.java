package lotto.domain;

import lotto.enums.MatchType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void 로또티켓과_당첨번호가_몇개_일치하는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 5, 14, 22, 45)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList()));

        List<LottoNo> winningNos = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        WinningLotto winningNumber = new WinningLotto(winningNos, new LottoNo(7));
        MatchType type = ticket.compareWinningLotto(winningNumber);
        boolean result = type.isMatching(3);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 로또티켓에_보너스볼이_당첨되었는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList()));

        List<LottoNo> winningNos = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        WinningLotto winningNumber = new WinningLotto(winningNos, new LottoNo(7));

        MatchType type = ticket.compareWinningLotto(winningNumber);
        int result = type.findMatchCount();
        assertThat(result).isEqualTo(MatchType.BONUS.findMatchCount());
    }
}