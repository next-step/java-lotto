package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    @DisplayName("전달받은 금액이 로또 금액으로 정확하게 나누어 떨어지면 로또를 발행한다.")
    void shouldIssueLottoWhenAmountIsDivisibleByLottoPrice() {
        final LottoStore lottoStore = new LottoStore();

        assertThat(lottoStore.purchase(new Money(3000)).size()).isEqualTo(3);
    }
}
