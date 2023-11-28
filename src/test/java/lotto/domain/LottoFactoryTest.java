package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("로또구매/자동 구매 개수/개수만큼 로또들을 준다")
    void buyLottos() {
        MyLottos myLottos = LottoFactory.buy(2);

        assertThat(myLottos.getLottos()).hasSize(2);
    }
}