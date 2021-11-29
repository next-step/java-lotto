package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 생성자 테스트")
    void constructor() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber("1"));
    }

    @Test
    @DisplayName("로또번호는 1~45까지만 가능하다.")
    void LottoNumber_1_45까지만_허용() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
