package lotto.store;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName(value = "구매 가능한 로또의 개수는 budget / price 이다")
    void count() {
        LottoStore lottoStore = new LottoStore(new Budget(10_000), 1_000);
        assertThat(lottoStore.purchaseCount()).isEqualTo(10);
    }

    @Test
    @DisplayName(value = "구매 불가능한 금액을 입력하는 경우 IllegalArgumentException 을 일으킨다")
    void isPurchasable() {
        assertThrows(IllegalArgumentException.class,
            () -> new LottoStore(new Budget(500), 1_000));
    }

    @Test
    @DisplayName(value = "lotto를 구매하기에 충분한 예산을 준비할 경우 어떠한 exception 도 발생하지 않고 Store가 생성된다")
    void noExceptionWhenConstruct() {
        assertDoesNotThrow(() ->
            new LottoStore(new Budget(10_000), 1_000));
    }

}
