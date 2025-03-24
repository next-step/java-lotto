package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(1);
    }

    @Test
    void 로또값은_1부터_45사이_값을_가진다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자는 1 - 45 사이만 가능합니다.");
    }

    @Test
    void 로또값_비교() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        assertThat(lottoNumber2).isGreaterThan(lottoNumber1);
    }

}
