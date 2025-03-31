package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private static final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    @Test
    @DisplayName("당첨 티켓에 로또 번호와 일치하는게 존재하는지 확인한다.")
    void matchTicket() {
        assertThat(winningLotto.matchTicket(new LottoNumber(1))).isTrue();
        assertThat(winningLotto.matchTicket(new LottoNumber(7))).isFalse();
    }

    @Test
    @DisplayName("보너스볼에 로또 번호와 일치하는게 존재하는지 확인한다.")
    void matchBonus() {
        assertThat(winningLotto.matchBonus(new LottoNumber(1))).isFalse();
        assertThat(winningLotto.matchBonus(new LottoNumber(7))).isTrue();
    }
}