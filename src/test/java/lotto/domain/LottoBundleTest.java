package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleTest {
    @Test
    @DisplayName("전달받은 수량만큼 로또를 발행한다.")
    void shouldIssueLottoBundleForGivenQuantity() {
        final LottoBundle lottoBundle = LottoBundle.createLottoBundle(5);
        assertThat(lottoBundle.size()).isEqualTo(5);
    }
}