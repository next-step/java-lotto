package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @ParameterizedTest
    @DisplayName("로또 자동 구매 성공 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_5개_구매_성공_테스트(int purchaseQuantity) {
        Lottos lottos = new Lottos(purchaseQuantity);
        assertThat(lottos.getLottos().size()).isEqualTo(purchaseQuantity);
    }
}
