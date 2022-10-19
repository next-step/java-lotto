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
    @DisplayName("지난 주 당첨 번호와 일치하는 개수를 반환한다.")
    void matches() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6), 7);
        int matchCount = winningLotto.matches(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 true 를 반환한다.")
    void bonus() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);
        boolean isMatched = winningLotto.matchBonus(Lotto.of(List.of(1, 2, 3, 4, 5, 7)));
        assertThat(isMatched).isTrue();
    }

    @Test
    @DisplayName("로또 번호 중 보너스 번호가 있으면 false 를 반환한다.")
    void doesNotMatchBonus() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);
        boolean isMatched = winningLotto.matchBonus(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(isMatched).isFalse();
    }
}
