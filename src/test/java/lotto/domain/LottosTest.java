package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 1, 15})
    void 로또_금액만큼_로또_생성_확인(int purchaseAmount) {
        assertThat(new Lottos(new PurchaseAmount(purchaseAmount)).getLottoAmount()).isEqualTo(purchaseAmount);
    }


}
