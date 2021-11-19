package lotto.model;

import common.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 N장 발행")
    void ticket() {
        Lotto lotto = new Lotto(10);
        assertThat(lotto.getLotto()).hasSize(10);
        OutputView.print(lotto);
    }
}