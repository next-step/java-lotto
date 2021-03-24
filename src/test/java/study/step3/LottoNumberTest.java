package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step3.domain.LottoNumber;

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
        assertThat(LottoNumber.of(Integer.parseInt(input)).toString()).isEqualTo(input);
    }
}
