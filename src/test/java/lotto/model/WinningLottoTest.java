package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 6개 중 6개 일치 확인")
    public void test1() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1,2,3,4,5,6)), LottoNumber.of(7));
        LottoTicket targetLotto = new LottoTicket(List.of(1,2,3,4,5,6));
        int matchCount = winningLotto.match(targetLotto);
        assertThat(matchCount)
                .isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호 6개 중 3개 일치 확인")
    public void test2() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1,2,3,4,5,6)), LottoNumber.of(7));
        LottoTicket targetLotto = new LottoTicket(List.of(1,2,3,8,9,10));
        int matchCount = winningLotto.match(targetLotto);
        assertThat(matchCount)
                .isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 번호 6개 중 5개 + 보너스 일치 확인")
    public void test3() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1,2,3,4,5,6)), LottoNumber.of(7));
        LottoTicket targetLotto = new LottoTicket(List.of(1,2,3,4,5,7));
        int matchCount = winningLotto.match(targetLotto);
        assertThat(matchCount)
                .isEqualTo(5);
    }
}