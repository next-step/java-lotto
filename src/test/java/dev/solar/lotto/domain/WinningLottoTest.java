package dev.solar.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("당첨 갯수를 확인한다.")
    @Test
    void check_winning_numbers() {
        final WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank result = winningLotto.match(new LottoTicket(Set.of(1, 2, 3, 45, 44, 43)));
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("5개 번호 일치 + 보너스 볼이 일치하면 2등이다.")
    @Test
    void rank_2th() {
        final WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 45);
        Rank result = winningLotto.match(new LottoTicket(Set.of(1, 2, 3, 4, 5, 45)));
        assertThat(result).isEqualTo(Rank.SECOND);
    }
}
