package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    public void 생성() {
        assertThat(new LottoCount("5000", "3")).isEqualTo(new LottoCount(5000, 3));
    }

    @Test
    public void 유효한_로또_개수() {
        assertThatThrownBy(() -> new LottoCount("1000", "2")).isInstanceOf(RuntimeException.class);
    }
}
