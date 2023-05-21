package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumbersTest {

    @Test
    void 보너스번호는_당첨번호와_겹칠수_없음() {
        Set<Integer> winNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        assertThatThrownBy(() -> new WinNumbers(winNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
    }

}
