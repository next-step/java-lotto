package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 1장 금액인 1000원 보다 적은 돈을 넣는 경우")
    void less_money() {
        LottoStore lottoStore = LottoStore.getInstance();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoStore.buyLotto(new Money(500L)));
    }

    @Test
    @DisplayName("로또 14장 구입")
    void lotto() {
        LottoStore lottoStore = LottoStore.getInstance();
        Lottos lottos = lottoStore.buyLotto(new Money(14000L));
        assertThat(lottos.size()).isEqualTo(14);
    }
}
