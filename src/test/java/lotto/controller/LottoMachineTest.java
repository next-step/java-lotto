package lotto.controller;

import lotto.exception.PriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoMachineTest {
    @DisplayName("금액을 지불한만큼 복권을 받는다.")
    @Test
    void buy() {
        int purchasingPrice = 5000;
        LottoMachine lottoMachine = new LottoMachine(purchasingPrice);
        int expected = 5;

        int actual = lottoMachine.getBuyingCount();

        assertEquals(expected, actual);
    }

    @DisplayName("구입 금액이 로또 금액보다 작을 경우 PriceException 을 발생한다.")
    @Test
    void noPurchaseException() {
        int purchasingPrice = 900;

        assertThatThrownBy(() -> new LottoMachine(purchasingPrice))
                .isInstanceOf(PriceException.class);
    }
}
