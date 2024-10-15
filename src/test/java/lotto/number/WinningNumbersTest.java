package lotto.number;

import lotto.exception.LottoIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @DisplayName("당첨 숫자에 포함된 수를 보너스 숫자로 사용하면 예외가 발생한다.")
    @Test
    void noDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumbers(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(1)))
                .isInstanceOf(LottoIllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자와 보너스 숫자로 객체를 만들 수 있다.")
    @Test
    void create() {

        WinningNumbers winningNumbers = new WinningNumbers(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        assertThat(winningNumbers).isEqualTo(new WinningNumbers(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7)));
    }
}
