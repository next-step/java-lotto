package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Test
    void 로또숫자가_중복되지_않는지() {
        LottoTicket lottoTicket = new LottoTicket();
        int distinctSize = (int) lottoTicket.getNumbers()
                .stream()
                .distinct()
                .count();
        assertThat(distinctSize).isEqualTo(LOTTO_NUMBER_COUNT);
    }


    @Test
    void 당첨숫자와_일치하는_숫자개수() {
        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(Set.of(
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(7),
                new LottoNumber(9),
                new LottoNumber(11))));
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket.getMatchCount(winningNumbers)).isEqualTo(3);
    }

}
