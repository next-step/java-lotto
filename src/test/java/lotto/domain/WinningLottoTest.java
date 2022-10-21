package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호는 중복이 불가하다.")
    void invalid() {
        assertThatThrownBy(() -> WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지난 주 당첨 번호와 일치하는 랭크를 반환한다.")
    void matches() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6), 7);
        Rank rank = winningLotto.matches(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
