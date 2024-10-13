package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

    @DisplayName("로또 자판기가 구입 금액을 기반으로 잘 생성되는지")
    @Test
    void lotteryMachineTest() {
        LotteryMachine machine1 = new LotteryMachine("1500");
        LotteryMachine machine2 = new LotteryMachine(1500);
        assertThat(machine1).isEqualTo(machine2);
    }
}
