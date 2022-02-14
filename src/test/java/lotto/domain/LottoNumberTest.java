package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_45초과일_때(){
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(50));
    }

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_1미만일_때(){
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(-1));
    }

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_범위를_만족할_때(){
        Assertions.assertThat(new LottoNumber(5)).isEqualTo(new LottoNumber(5));
    }

}
