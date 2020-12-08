package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNoTest {

    @Test
    void create() {
        LottoNo lottoNo = new LottoNo(1);
        assertThat(lottoNo).isEqualTo(new LottoNo(1));
    }

    @Test
    @DisplayName(value = "1부터 45 사이의 숫자가 아니면 IllegalArgumentException")
    void valid() {
        assertThatThrownBy(() -> LottoNo.create(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNo.create(46))
                .isInstanceOf(IllegalArgumentException.class);

    }
}