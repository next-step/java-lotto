package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void lotto_number_exception() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
    }

    @Test
    void lotto_number() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

}
