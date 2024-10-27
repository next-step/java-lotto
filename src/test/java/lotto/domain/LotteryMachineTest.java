package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class LotteryMachineTest {

    @DisplayName("로또 구매 금액과 수동 발급 로또 번호로 잘 생성되는지")
    @Test
    void lotteryMachineTest() {
        assertThat(LotteryMachine.createWithManualLottos(List.of("1, 2, 3, 6, 7, 8", "2, 4, 5, 6, 8, 25"), 2000).getLottos().size())
                .isEqualTo(2);
    }

    @DisplayName("로또 구매 금액보다 더 많은 개수의 수동 발급 로또 번호로 생성할 경우 IllegalArgumentException을 잘 반환하는지")
    @Test
    void lotteryMachineTest_withManualLottoCountExceed() {
        assertThatThrownBy(() -> LotteryMachine.createWithManualLottos(List.of("1, 2, 3, 6, 7, 8", "2, 4, 5, 6, 8, 25"), 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
