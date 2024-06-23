package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 6개를 입력하면 로또 티켓에 숫자가 몇개 일치하는지 반환한다.")
    public void test1() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1,2,3,4,5,6)), LottoNumber.of(7));
        LottoTicket targetLotto = new LottoTicket(List.of(1,2,3,4,5,6));
        int matchCount = winningLotto.match(targetLotto);
        assertThat(matchCount)
                .isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호 6개를 입력하면 로또 티켓에 숫자와 보너스볼 일치 개수를 반환한다.")
    public void test2() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1,2,3,4,5,6)), LottoNumber.of(7));
        LottoTicket targetLotto = new LottoTicket(List.of(1,2,3,4,5,7));
        int matchCount = winningLotto.match(targetLotto);
        assertThat(matchCount)
                .isEqualTo(6);
    }
}