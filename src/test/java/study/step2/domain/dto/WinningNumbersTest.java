package study.step2.domain.dto;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step2.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumbersTest {

    @Test
    void 당첨_번호_개수_부족() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3)))
            .withMessage("당첨 번호 개수는 6개여야 합니다.");
    }

    @Test
    void 당첨_번호_허용_범위_미만_초과() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
            .withMessage("당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }
}
