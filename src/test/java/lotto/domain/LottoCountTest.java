package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    public void 생성() {
        assertThat(new LottoCount("3")).isEqualTo(new LottoCount(3));
    }

    @Test
    public void 로또_가격_생성() {
        assertThat(new LottoCount("3000", 1000)).isEqualTo(new LottoCount(3));
    }
}
