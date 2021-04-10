package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create(){
        LottoNumber lottoNumber = LottoNumber.lottoNumber(1);
        assertThat(lottoNumber.equals(LottoNumber.lottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("로또 번호 범위 체크")
    public void abnormalNumber(){
        assertThatIllegalArgumentException().isThrownBy (() ->  LottoNumber.lottoNumber(0));
        assertThatIllegalArgumentException().isThrownBy (() ->  LottoNumber.lottoNumber(46));
    }


}
