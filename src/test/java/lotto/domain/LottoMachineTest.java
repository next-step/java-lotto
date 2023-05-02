package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 발급 테스트")
    void issueAutoForMoney() {


        assertThat(LottoMachine.issueAutoForMoney(Money.wons(2000))).hasSize(2);
    }
}