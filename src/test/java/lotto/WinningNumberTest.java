package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    void 로또당첨번호_6개아님_숫자3개입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 2, 3),
                4
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨번호는 6개 입니다.");
    }

    @Test
    void 이미존재하는_보너스번호_입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 2, 3, 4, 5, 6),
                1
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 번호입니다.");
    }

    @Test
    void 중복된_로또번호_입력() {
        assertThatThrownBy(() -> new WinningNumbers(
                List.of(1, 1, 3, 4, 5, 6),
                7
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 입력되었습니다.");
    }

}
