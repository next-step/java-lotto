package study.step3.view;

import org.junit.jupiter.api.Test;
import study.step3.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static study.step3.view.InputParser.parse;

public class InputParserTest {

    @Test
    void 컴마로_구분되지_않음() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> parse("a, b, c, d, e"))
            .withMessage("로또 번호는 숫자를 입력해야 합니다.");
    }
}
