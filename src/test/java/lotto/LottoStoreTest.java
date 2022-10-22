package lotto;

import static lotto.exception.ExceptionMessage.ERROR_NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoStorage;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.strategy.AutoIssueLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("buyLotto 메소드는 주어진 돈으로 살 수 있는 최대 개수의 로또를 발권하고 이를 LottoStorage 객체에 저장하여 돌려준다.")
    void buyLotto() {
        LottoStore store = LottoStore.getInstance();
        LottoStorage storage = store.buyLotto(new Money(14000), AutoIssueLottoStrategy.getInstance());

        assertThat(storage.getLottos().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("주어진 돈이 로또 가격보다 적으면 로또를 구매할 수 없다.")
    void failToBuyLotto() {
        LottoStore store = LottoStore.getInstance();
        assertThatThrownBy(() ->
            store.buyLotto(new Money(100), AutoIssueLottoStrategy.getInstance()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_NOT_ENOUGH_MONEY.getMessage());
    }
}
