package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 1);
        assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 1));
    }

    @Test
    @DisplayName("보너스볼은 당첨번호에 포함 x -> IllegalArgumentException")
    void validation() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
        // 정상
        assertThatCode(() -> new WinningLotto(winningNumbers, 1))
                .doesNotThrowAnyException();
    }


}