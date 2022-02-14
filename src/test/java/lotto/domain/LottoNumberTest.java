package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_45초과일_때는_에러가_발생(){
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(50));
    }

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_1미만일_때는_에러가_발생(){
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(-1));
    }

    @Test
    public void 로또숫자_범위가_1이상_45이하_테스트_범위를_만족할_때는_성공(){
        Assertions.assertThat(new LottoNumber(5)).isEqualTo(new LottoNumber(5));
    }

}
