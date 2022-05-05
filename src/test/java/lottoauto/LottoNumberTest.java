package lottoauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    void LottoNumber_생성() {
        assertThat(LottoNumber.from(1).equals(LottoNumber.from("1"))).isTrue();
        assertThat(LottoNumber.from(1) == LottoNumber.from(1)).isTrue();
    }
}