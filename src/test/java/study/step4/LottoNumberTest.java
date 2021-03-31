package study.step4;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step4.domain.LottoNumber;

public class LottoNumberTest {

    @Test
    @DisplayName("유효성 테스트")
    void valid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(-1));
    }

    @ParameterizedTest(name = "로또 번호 생성 테스트")
    @ValueSource(strings = {"1", "45"})
    public void of(String input) {
        // given
        int test = Integer.parseInt(input);
        LottoNumber lottoNumber = LottoNumber.of(test);
        // when & then
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(test));
    }
}
