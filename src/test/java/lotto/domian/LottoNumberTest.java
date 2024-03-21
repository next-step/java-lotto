package lotto.domian;

import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.ConstantSet.MIN_LOTTO_NUMBER;
import static lotto.common.ConstantSet.MAX_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호는_1~45 범위 밖의 수는 예외를 발생시킨다.")
    void lottoNumberShouldBeWithinRange_orException(){
        assertThatThrownBy(()->{
            LottoNumber.of(46);
        }).isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또 번호는 %d와(과) %d 사이의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    }
}
