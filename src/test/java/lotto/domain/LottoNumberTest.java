package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("Number 생성")
    void test01() {
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아니면 에러를 발생한다.")
    void test02() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
