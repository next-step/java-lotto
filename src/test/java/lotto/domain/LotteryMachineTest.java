package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

    @DisplayName("로또 자판기가 구입 금액을 기반으로 잘 생성되는지")
    @Test
    void lotteryMachineTest() {
        LotteryMachine machine1 = new LotteryMachine("15000");
        LotteryMachine machine2 = new LotteryMachine(15000);
        assertThat(machine1).isEqualTo(machine2);
    }

    @DisplayName("로또 자판기가 발급된 로또 개수를 잘 반환하는지")
    @Test
    void getIssuedLottoNumberTest() {
        assertThat(new LotteryMachine(15000).getIssuedLottoNumber()).isEqualTo(15);
    }
}
