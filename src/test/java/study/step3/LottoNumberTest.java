package study.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step3.domain.LottoNumber;

public class LottoNumberTest {

    @Test
    @DisplayName("유효성 테스트")
    void valid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(-1));
    }
}
