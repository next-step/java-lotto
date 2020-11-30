package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 잘 생성되는지 확인")
    public void create_of_lotto_number() {

        LottoNumber num1 = new LottoNumber(1);
        LottoNumber num2 = new LottoNumber(1);

        assertThat(num1.equals(num2)).isTrue();

    }

    @Test
    @DisplayName("로또 번호에 46이 입력되는 경우 ")
    public void 로또번호에_46_이_있는경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(46)
                );
    }

    @Test
    @DisplayName("로또 번호에 0이 입력되는 경우 ")
    public void 로또번호에_0_이_있는경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(0)
                );
    }

}