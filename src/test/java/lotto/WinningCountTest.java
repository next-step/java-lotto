package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningCountTest {

    @DisplayName(value = "count가 0미만이면 예외 발생")
    @Test
    void count가_0미만이면_예외() {
        // given
        int count = -1;

        // when
        assertThatThrownBy(() -> {
            new WinningCount(-1);
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "티켓 1장의 당첨 갯수 테스트")
    @Test
    void 당첨_갯수() {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(ticket);
        List<Integer> lastWeeksWinningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);

        // when
        WinningCount winningCount = new WinningCount(0);
        winningCount = winningCount.increaseCountManager(lottoTicket, lastWeeksWinningNumbers);

        WinningCount expect = new WinningCount(3);

        // then
        assertThat(winningCount).isEqualTo(expect);
    }
}