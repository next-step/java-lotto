package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("천원보다 낮은 금액을 입력한 경우 IllegalArgumentException 발생함..")
    void buyLotto_isNotEnoughFee_IllegalArgumentException() {
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.buy(990))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매를 요청한 경우 천원당 하나의 로또를 반환함.")
    void buyLotto() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.buy(1000).size()).isEqualTo(1);
        assertThat(lottoStore.buy(3000).size()).isEqualTo(3);

    }
}