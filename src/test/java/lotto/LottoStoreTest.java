package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoStorage;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.strategy.AutoIssueLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("buyLotto 메소드는 넘겨받은 돈으로 살 수 있는 최대 개수의 로또를 발권하고 이를 LottoStorage 객체에 저장하여 돌려준다.")
    void buyLotto() {
        LottoStore store = LottoStore.getInstance();
        LottoStorage storage = store.buyLotto(new Money(14000), AutoIssueLottoStrategy.getInstance());

        assertThat(storage.getLottos().size()).isEqualTo(14);
    }
}
