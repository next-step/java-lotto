package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 1장을 주고 1000원을 차감한다")
    void purchase() {
        Money money = new Money(1000);
        Lotto lotto = LottoStore.purchase(money);
        assertThat(lotto).isNotNull();
        assertThat(money.amount()).isEqualTo(0);
    }
}
