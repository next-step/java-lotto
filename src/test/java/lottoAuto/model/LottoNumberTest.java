package lottoAuto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @DisplayName("LottoNumber객체를 생성한다.")
    @Test
    public void LottoNumberTest() {
        assertThat(new LottoNumber(30)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("로또번호는 45이상이면 예외를 발생시킨다.")
    @Test
    public void invalidateLottoNumber() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(50));
    }

    @DisplayName("로또 번호가 일치하는지 확인한다.")
    @Test
    public void hasNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(30);
        assertThat(lottoNumber.hasNumber(30)).isTrue();
    }
}
