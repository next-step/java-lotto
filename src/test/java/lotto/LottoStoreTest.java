package lotto;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStoreTest {
    @Test
    @DisplayName("입력금액만큼 로또가 생성되는지 테스트(1000원에 로또 1장)")
    void buyLottoTest() {
        int money = 5000;
        assertThat(LottoStore.buyLotto(money)).isEqualTo(money / 1000);
    }
}
