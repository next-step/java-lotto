package lotto.model;

import lotto.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 N장 발행")
    void ticket() {
        Lotto lotto = LottoFactory.autoCreateLotto(10);
        assertThat(lotto.getLotto()).hasSize(10);
    }

}