package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 번호는 반드시 6개여야 한다")
    void lottoMustHaveSixNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void lottoNumbersMustBeUnique() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1~45 범위여야 한다")
    void lottoNumbersMustBeInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 목록은 오름차순으로 반환된다")
    void lottoNumbersAreSorted() {
        Lotto lotto = new Lotto(List.of(43, 21, 8, 42, 41, 23));

        assertThat(lotto.numbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 계산한다")
    void matchCountCalculation() {
        Lotto ticket = new Lotto(1, 2, 3, 10, 11, 12);
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(ticket.matchCount(winning)).isEqualTo(3);
    }
}
