package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    void 당첨숫자와_일치하는_숫자개수() {
        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(Set.of(1, 3, 5, 7, 9, 11)));
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(3);
    }

}
