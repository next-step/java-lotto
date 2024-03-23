package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("1~45 사이의 숫자를 가지고 LottoNumber 객체를 생성할 수 있다.")
    @Test
    void test01() {
        LottoNumber lottoNumber = new LottoNumber(10);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }

    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외 발생")
    @Test
    void test02() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자만 가능합니다.");
    }
}
