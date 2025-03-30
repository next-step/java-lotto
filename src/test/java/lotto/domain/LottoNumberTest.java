package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호 유효성 검사사 테스트")
    @Test
    void create_lotto() {
        assertThat(new LottoNumber(3))
                .extracting("number")
                .isEqualTo(3);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(50));
    }

    @DisplayName("로또 번호 비교 테스트")
    @Test
    void compare_lotto() {
        LottoNumber number1 = new LottoNumber(3);
        LottoNumber number2 = new LottoNumber(3);
        LottoNumber number3 = new LottoNumber(4);
        assertThat(number1 == number2)
                .isTrue();
        assertThat(number3.comparTo(number2) > 0)
                .isTrue();
    }
}
