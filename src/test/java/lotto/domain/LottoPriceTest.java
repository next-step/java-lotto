package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPriceTest {
    @Test
    public void 로또의_가격에_따른_개수() {
        assertThat(new LottoPrice(14000).count()).isEqualTo(14);
    }
}
