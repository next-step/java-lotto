package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    public void 생성() {
        assertThat(LottoNumber.get(1)).isEqualTo(LottoNumber.get("1"));
    }

    @Test
    public void 캐싱() {
        assertThat(LottoNumber.get(1)).isEqualTo(LottoNumber.get(1));
    }

    @Test
    public void 유효하지_않은_숫자() {
        assertThatThrownBy(() -> LottoNumber.get(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
