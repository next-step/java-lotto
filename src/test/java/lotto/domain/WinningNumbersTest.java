package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName(value = "당첨 번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void distinctWinningAndBonus() {
        assertThatThrownBy(() -> new WinningNumbers(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), new LottoNumber(6))).isInstanceOf(IllegalArgumentException.class);
    }
}
