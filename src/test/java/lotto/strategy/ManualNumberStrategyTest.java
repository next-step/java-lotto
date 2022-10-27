package lotto.strategy;

import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManualNumberStrategyTest {
    
    @Test
    void null_또는_blank() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy(null))
                .withMessageMatching("0 이상의 숫자를 입력하세요.");
    }

    @Test
    void 음수() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy("-2"))
                .withMessageMatching("0 이상의 숫자를 입력하세요.");
    }

    @Test
    void 문자() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy("s"))
                .withMessageMatching("0 이상의 숫자를 입력하세요.");
    }

    @Test
    void 숫자_모두_확인() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new ManualNumberStrategy("2,3,d"))
                .withMessageMatching("0 이상의 숫자를 입력하세요.");
    }
}