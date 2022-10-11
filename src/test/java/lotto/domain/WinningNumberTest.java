package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("생성자 검증")
    void constructorDI() {
        assertThatThrownBy(() -> new WinningNumber(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번홓 조회")
    void winningNumber() {
        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new WinningNumber(lottoTicket).winningNumber()).isEqualTo(lottoTicket);
    }
}
