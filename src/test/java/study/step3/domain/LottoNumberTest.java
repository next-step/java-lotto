package study.step3.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step3.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.step3.domain.Lotto.validateNumbers;

public class LottoNumberTest {

    @Test
    void 번호_허용_범위_미만_초과() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoNumber(46))
            .withMessage("번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 번호_개수_부족() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> validateNumbers(List.of(1, 2, 3)))
            .withMessage("번호는 6자리 중복되지 않은 값이어야 합니다.");
    }

    @Test
    void 번호_중복() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> validateNumbers(List.of(1, 2, 3, 4, 5, 5)))
            .withMessage("번호는 6자리 중복되지 않은 값이어야 합니다.");
    }
}
