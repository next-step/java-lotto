package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class LotteryMachineTest {

    @DisplayName("로또 자판기가 구매 금액과 수동 로또 번호를 기반으로 알맞은 로또 개수를 잘 구매하는지")
    @Test
    void getIssuedLottoNumberTest() {
        assertThat(new LotteryMachine(14500).getPurchasedLottoCount())
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

    private static Stream<Arguments> lottoRankSummaryArguments() {
        return Stream.of(
                Arguments.of("1, 2, 3, 7, 8, 9", 3),
                Arguments.of("4, 5, 6, 10, 11, 12", 3),
                Arguments.of("1, 2, 3, 4, 5, 6", 6),
                Arguments.of("21, 22, 23, 24, 25, 27", 0)
        );
    }

    @DisplayName("로또 구매 금액과 수동 발급 로또 번호로 잘 생성되는지")
    @Test
    void lotteryMachineTest() {
        assertThat(new LotteryMachine(List.of("1, 2, 3, 6, 7, 8", "2, 4, 5, 6, 8, 25"), "2000").getLottos().size())
                .isEqualTo(2);
    }

    @DisplayName("로또 구매 금액보다 더 많은 개수의 수동 발급 로또 번호로 생성할 경우 IllegalArgumentException을 잘 반환하는지")
    @Test
    void lotteryMachineTest_withManualLottoCountExceed() {
        assertThatThrownBy(() -> new LotteryMachine(List.of("1, 2, 3, 6, 7, 8", "2, 4, 5, 6, 8, 25"), "1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
