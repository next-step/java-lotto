package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {
    @Test
    @DisplayName("로또 1장의 금액보다 낮은 금액은 받을 수 없다.")
    void shouldRejectAmountLessThanLottoPrice() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoStore(new Money(999)));
    }

    @Test
    @DisplayName("전달받은 금액이 로또 금액으로 정확하게 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void shouldThrowExceptionIfAmountIsNotDivisibleByLottoPrice() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoStore(new Money(12300)));
    }

    @Test
    @DisplayName("전달받은 금액이 로또 금액으로 정확하게 나누어 떨어지면 로또를 발행한다.")
    void shouldIssueLottoWhenAmountIsDivisibleByLottoPrice() {
        final LottoStore lottoStore = new LottoStore(new Money(2000));

        assertThat(lottoStore.issue().size()).isEqualTo(2);
    }
}
