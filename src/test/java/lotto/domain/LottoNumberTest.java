package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("로또 넘버는 1~45 사이의 값이 아니라면 에러가 발생한다.")
    @Test
    public void vaildLottoNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoNumber lottoNumber = LottoNumber.getLottoNumber(0);
                }).withMessageContaining("숫자 범위 벗어남");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoNumber lottoNumber = LottoNumber.getLottoNumber(46);

                }).withMessageContaining("숫자 범위 벗어남");
    }

}
