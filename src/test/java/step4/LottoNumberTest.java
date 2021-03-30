package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("각각의 로또 넘버 생성")
    public void lottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(4);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(4));
    }

    @Test
    @DisplayName("로또번호 1~45사이 체크")
    public void checkNumber() {
        assertThatThrownBy(() -> {
            new LottoNumber(56);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
