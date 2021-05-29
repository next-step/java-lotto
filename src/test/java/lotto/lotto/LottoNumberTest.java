package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.error.ErrorMessage;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 넘버 생성")
    void create() {
        //given
        //when
        LottoNumber number = LottoNumber.of(1);
        //then
        assertThat(number.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("잘못 된 번호 생성")
    void createInvalidNumber() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(100)).withMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("같은 번호 체크")
    void testEquals() {
        //given
        //when
        //then
        assertThat(LottoNumber.of(1).equals(LottoNumber.of(1))).isTrue();
    }

    @Test
    @DisplayName("캐싱을 이용하는지 확인")
    void testCache() {
        //given
        //when
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);
        //then
        assertThat(lottoNumber1 == lottoNumber2).isTrue();
    }
}