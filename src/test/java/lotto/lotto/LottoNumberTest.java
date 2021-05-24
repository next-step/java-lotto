package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 넘버 생성")
    void create() {
        //given
        LottoNumber lottoNumber = new LottoNumber(1);
        //when
        int number = lottoNumber.getNumber();
        //then
        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("잘못 된 번호 생성")
    void createInvalidNumber() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(100)).withMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("같은 번호 체크")
    void testEquals() {
        //given
        //when
        LottoNumber lottoNumber = new LottoNumber(1);
        //then
        assertThat(lottoNumber.equals(new LottoNumber(1))).isTrue();
    }
}