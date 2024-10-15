package lotto;

import lotto.entity.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("당첨 번호화 로또 번호가 일치하지 않는 경우")
    public void 당첨번호_로또번호_일치하지_않음() {
        Lotto lottoTicket = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto("7, 8, 9, 10, 11, 12");

        int matchCount = lottoTicket.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    @DisplayName("당첨 번호화 로또 번호가 일치하는 경우")
    public void 당첨번호_로또번호_일치하지() {
        Lotto lottoTicket = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto("1, 2, 3, 10, 11, 12");

        int matchCount = lottoTicket.matchCount(winningLotto);

        assertThat(matchCount).isEqualTo(3);

    }
}
