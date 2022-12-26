package lotto;

import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LottoNumbersTest {

    @Test
    @DisplayName("로또 캐싱 생성 객체 비교")
    public void lottoObjectEqual(){
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);
        assertThat(lottoNumber1 == lottoNumber2).isTrue();
    }

    @Test
    @DisplayName("로또 MAX값(45) 초과 시 에러발생")
    public void lottoMaxNumberTest(){
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 로또 번호입니다.");
    }

    @Test
    @DisplayName("로또 MIN값(1) 미만 시 에러발생")
    public void lottoMinNumberTest(){
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 로또 번호입니다.");
    }
}
