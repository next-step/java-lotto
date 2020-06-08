package lotto.domain.data;

import lotto.domain.data.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또번호는 1부터 45까지 숫자로 정상적으로 생성된다.")
    @Test
    public void createLottoNumberTest(){
        LottoNumber lottoNumber = LottoNumber.of(15);

        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("1부터 45이외 숫자가 오면 IllegalArgumet Exception 이 발생한다.")
    @Test
    public void createLottoNumberExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() ->  LottoNumber.of(-1));
        assertThatIllegalArgumentException().isThrownBy(() ->  LottoNumber.of(46));
    }
}
