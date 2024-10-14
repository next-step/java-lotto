package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

    @DisplayName("로또 자판기가 구매 금액을 기반으로 알맞은 로또 개수를 잘 구매하는지")
    @Test
    void getIssuedLottoNumberTest() {
        assertThat(new LotteryMachine(14500).getLottos()
                .size())
                .isEqualTo(14);
    }

    @DisplayName("숫자가 아닌 값으로 생성될 경우 NumberFormatException을 잘 반환하는지")
    @Test
    void lotteryMachineTest_withNonNumericValue() {
        assertThatThrownBy(() -> new LotteryMachine("abcd"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("음수로 생성된 경우 IllegalArgumentException을 잘 반환하는지")
    @Test
    void lotteryMachineTest_withNegativeValue() {
        assertThatThrownBy(() -> new LotteryMachine(-1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
