package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.Number.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 보너스번호_일치_여부() {
        Lotto lotto = new Lotto(numbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsBonusNumber(new InputNumber("1, 2, 3, 4, 5, 7", "6"))).isTrue();
        assertThat(lotto.containsBonusNumber(new InputNumber("1, 2, 3, 4, 5, 6", "7"))).isFalse();
    }

    @Test
    void 당첨번호와_로또번호의_일치_개수_총합() {
        Lotto lotto = new Lotto(numbers(1, 2, 3, 4, 5, 6));
        assertThat(lotto.countWinningNumbers(new InputNumber("1, 2, 3, 4, 5, 6", "7"))).isEqualTo(6);
    }
}
