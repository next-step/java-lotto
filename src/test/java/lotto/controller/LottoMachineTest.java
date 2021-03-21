package lotto.controller;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private Money money;

    @BeforeAll
    void setUp() {
        money = new Money("14000");
    }

    @DisplayName("금액에 맞는 로또 갯수를 반환한다.")
    @Test
    void getLottoCountTest() {
        assertThat(new LottoMachine().getLottoCount(money)).isEqualTo(14);
    }
}
