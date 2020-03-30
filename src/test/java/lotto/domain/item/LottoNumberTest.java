package lotto.domain.item;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumberTest {

    @DisplayName("1 ~ 45 사이의 숫자가 아니면 exception이 발생한다")
    @Test
    public void create_fail_outOfRange() throws Exception {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(50)).isInstanceOf(ValidLottoException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(ValidLottoException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(-10)).isInstanceOf(ValidLottoException.class)
        );
    }

    @DisplayName("같은 번호의 멤버변수를 가지면 동일 객체로 본다")
    @Test
    public void equals_succes() throws Exception {
        //given
        LottoNumber lottoNumber = new LottoNumber(10);
        LottoNumber lottoNumber2 = new LottoNumber(10);

        assertThat(lottoNumber).isEqualTo(lottoNumber2);
    }

    @DisplayName("서로 다른 번호의 멤버변수를 가지면 다른 객체로 본다")
    @Test
    public void equals_fail() throws Exception {
        //given
        LottoNumber lottoNumber = new LottoNumber(10);
        LottoNumber lottoNumber2 = new LottoNumber(20);

        assertThat(lottoNumber).isNotEqualTo(lottoNumber2);
    }


    @DisplayName("멤버변수의 숫자가 크면 더 큰것으로 판단한다")
    @Test
    public void compareTo_fail() throws Exception {
        //given
        LottoNumber lottoNumber = new LottoNumber(30);
        LottoNumber lottoNumber2 = new LottoNumber(10);

        assertThat(lottoNumber).isGreaterThan(lottoNumber2);
    }
}
