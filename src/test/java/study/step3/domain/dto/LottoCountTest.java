package study.step3.domain.dto;

import org.junit.jupiter.api.Test;
import study.step3.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoCountTest {

    @Test
    void 음수() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoCount(-1))
            .withMessage("로또 수량은 0이상 이어야 합니다.");
    }
}
