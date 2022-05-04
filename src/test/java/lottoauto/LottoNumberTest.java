package lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    void 로또번호_비교() {
        assertThat(LottoNumber.of(1).equals(LottoNumber.of(1))).isTrue();
        assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
    }
}