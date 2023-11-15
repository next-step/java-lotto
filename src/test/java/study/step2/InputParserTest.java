package study.step2;

import org.junit.jupiter.api.Test;
import study.step2.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.step2.view.InputParser.parse;

public class InputParserTest {

    @Test
    void 컴마로_구분되지_않음() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> parse("a, b, c, d, e"))
            .withMessage("당첨 번호는 숫자를 입력해야 합니다.");
    }
}
