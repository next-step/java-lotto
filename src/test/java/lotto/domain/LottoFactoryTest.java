package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @DisplayName("금액에 맞는 로또 수량을 구매한다.")
    @Test
    void buy() {
        Lottos lottos = LottoFactory.createPerPrice(14000);

        assertThat(lottos.quantity()).isEqualTo(14);
    }
}
