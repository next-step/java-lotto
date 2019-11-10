package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {
    @Test
    void crate() {
        final LottoPrice lottoPrice = new LottoPrice(1000);
        assertThat(lottoPrice).isEqualTo(new LottoPrice(1000));
    }

    @Test
    void createNot1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrice(900));
    }
}