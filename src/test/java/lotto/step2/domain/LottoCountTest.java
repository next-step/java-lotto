package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {
    @Test
    @DisplayName("구매금액을 입력해서 몇장의 로또를 구매할 수 있는지(1000원 이상일 때)")
    void correctLottoCount() {
        LottoCount lottoCount = new LottoCount(14000);
        assertThat(lottoCount.getLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("1000원 이하의 구매금액을 입력하면 예외 throw")
    void failLottoCount() {
        assertThatThrownBy(() -> new LottoCount(500)).isInstanceOf(IllegalArgumentException.class);
    }
}