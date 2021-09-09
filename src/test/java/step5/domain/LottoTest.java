package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("수동 구매 수량이 총 구매수량을 넘을 수 없다.")
    @Test
    void manualLottoNumberTest() {
        Lotto lotto = new Lotto(5000);
        Assertions.assertThatThrownBy(() -> {
            lotto.buyManually(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}