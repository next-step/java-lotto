package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    public void 생성() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
