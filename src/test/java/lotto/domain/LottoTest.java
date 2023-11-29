package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("6자리 테스트")
    @Test
    void numberDigitTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위 테스트")
    @Test
    void numberRangeTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 일치 개수 확인 테스트")
    @Test
    void matchCountTest() {
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 10));
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(5);
    }
}
