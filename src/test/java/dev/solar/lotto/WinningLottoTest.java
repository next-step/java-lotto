package dev.solar.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.solar.lotto.domain.LottoTicket;
import dev.solar.lotto.domain.WinningLotto;

public class WinningLottoTest {
    @DisplayName("당첨 갯수를 확인한다.")
    @Test
    void check_winning_numbers() {
        final WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5));
        int result = winningLotto.match(new LottoTicket(Set.of(1, 2, 3, 45, 44, 43)));
        assertThat(result).isEqualTo(3);
    }
}
