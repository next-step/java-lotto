package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("Lotto Number 생성 테스트")
    @Test
    public void test(){
        LottoNumber lottoNumber1 = LottoNumber.of(40);
        LottoNumber lottoNumber2 = LottoNumber.of(40);
        LottoNumber lottoNumber3 = LottoNumber.of(39);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
        assertThat(lottoNumber1).isNotEqualTo(lottoNumber3);
    }

    @DisplayName("Lotto Number 생성 오류 테스트")
    @Test
    public void test2(){
        assertThatIllegalArgumentException().isThrownBy(()-> LottoNumber.of(46));

    }

}